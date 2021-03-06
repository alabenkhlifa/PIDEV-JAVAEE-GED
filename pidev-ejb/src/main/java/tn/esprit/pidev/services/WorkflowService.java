package tn.esprit.pidev.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;

import tn.esprit.pidev.persistance.WFPriorite;
import tn.esprit.pidev.persistance.WFStatus;
import tn.esprit.pidev.persistance.WFType;
import tn.esprit.pidev.persistance.Workflow;

@Stateless
//@LocalBean
//@WebService(serviceName="WorkflowService")
//
//@Path("/")
public class WorkflowService extends Application implements WorkflowServiceLocal,WorkflowServiceRemote {

	@PersistenceContext//(unitName="WorkflowService", type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	public WorkflowService() {

	}

	@Override
	public void createWorkFlow(Workflow W) {
		em.persist(W);
	}

	@Override
	public void saveWorkFlow(Workflow W) {
		em.merge(W);
	}

	
	@Override
//	@WebMethod(operationName="getWorkflows")
//	@GET
	public List<Workflow> findAllWorkFlows(/*@PathParam("archive")*/Boolean archive) {
		return em.createQuery("select w from Workflow w where w.archive=:arch order by w.id asc", Workflow.class).setParameter("arch", archive).getResultList();
	}

	@Override
	public void removeWorkFlow(Workflow W) {
		em.remove(em.merge(W));
	}

	@Override
	public void removeWorkFlowById(int id) {

		Workflow w = findWorkFlowById(id);
		em.remove(w);
		em.flush();
	}

	@Override
	public Workflow findWorkFlowById(int id) {
		return em.find(Workflow.class, id);
	}

	@Override
	public void createWorkFlowFromDetach(Workflow W) {
		em.persist(em.merge(W));
		em.flush();
	}
	
	@Override
	public Boolean existantWorkflow(int id){
		Workflow w = findWorkFlowById(id);
		if (w.getId()>0)
			return true;
		return false;
	}
	
	@Override
	public List<Workflow> findCurrentWorkflows(Boolean archive) {
		return em.createQuery("select w from Workflow w where w.dateLimite > CURRENT_DATE and w.archive=:arch order by w.id asc", Workflow.class).setParameter("arch", archive).getResultList();
	}
	@Override
	public List<Workflow> findWorkflowsbyType(Boolean archive,WFType type){
		return em.createQuery("select w from Workflow w where w.type=:t and w.archive=:arch order by w.id asc", Workflow.class).setParameter("arch", archive).setParameter("t", type).getResultList();
	}
	@Override
	public List<Workflow> findWorkflowsbyCreateur(Boolean archive,int idCreateur){
		return em.createQuery("select w from Workflow w where w.createur.id=:idcreateur and w.archive=:arch order by w.id asc", Workflow.class).setParameter("arch", archive).setParameter("idcreateur", idCreateur).getResultList();
	}
	@Override
	public void archiverworkflow(int idWorkflow){
		em.createQuery("UPDATE Workflow w SET w.archive=true WHERE w.id =:idw").setParameter("idw", idWorkflow).executeUpdate();
	}
	@Override
	public void dearchiverworkflow(int idWorkflow){
		em.createQuery("UPDATE Workflow w SET w.archive=false WHERE w.id =:idw").setParameter("idw", idWorkflow).executeUpdate();
	}
	@Override
	public List<Workflow> findWorkflowsbyStatus(Boolean archive,WFStatus status){
		return em.createQuery("select w from Workflow w where w.status=:stat and w.archive=:arch order by w.id asc", Workflow.class).setParameter("stat", status).setParameter("arch", archive).getResultList();
	}

	@Override
	public void createWorkflowfromScratch(Date avantLe, Boolean archived, WFPriorite priorite) {
		// TODO Complete this methode
		
	}
}
