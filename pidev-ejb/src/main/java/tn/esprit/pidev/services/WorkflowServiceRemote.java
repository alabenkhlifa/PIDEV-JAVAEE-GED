package tn.esprit.pidev.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import tn.esprit.pidev.persistance.WFPriorite;
import tn.esprit.pidev.persistance.Workflow;

@Remote

public interface WorkflowServiceRemote {
	public void createWorkFlow(Workflow W);
	@WebResult(name="createworkflow")
	public void createWorkflowfromScratch(Date avantLe,Boolean archived,WFPriorite priorite);
	public void saveWorkFlow(Workflow W);
	@WebResult(name="getallworkflow")
	public List<Workflow> findAllWorkFlows(Boolean archive);
	public void removeWorkFlow(Workflow W);
	public Workflow findWorkFlowById(int id);
	public void removeWorkFlowById(int id);
	public Boolean existantWorkflow(int id);
}
