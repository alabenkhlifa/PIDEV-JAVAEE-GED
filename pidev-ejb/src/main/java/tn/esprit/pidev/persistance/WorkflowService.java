package tn.esprit.pidev.persistance;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class WorkflowService implements WorkflowServiceLocal {

	@PersistenceContext
	private EntityManager em;

	public WorkflowService() {

	}

	@Override
	public void createWorkFlow(Workflow W) {
		em.persist(W);
	}

	@Override
	public void saveWorkFlow(Workflow W) {
		Workflow existing = em.find(Workflow.class, W.getId());
		em.merge(existing.merge(W));
	}

	@Override
	public List<Workflow> findAllWorkFlows() {
		return em.createQuery("select w from Workflow w order by w.id asc", Workflow.class).getResultList();
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
		// TODO Auto-generated method stub
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
	
	public void testguit(){
		System.out.print("test");
	}
}
