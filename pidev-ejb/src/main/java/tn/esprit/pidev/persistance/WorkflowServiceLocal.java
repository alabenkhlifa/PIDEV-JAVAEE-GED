package tn.esprit.pidev.persistance;

import java.util.List;

import javax.ejb.Local;


@Local
public interface WorkflowServiceLocal  {
	public void createWorkFlow(Workflow W);
	public void createWorkFlowFromDetach(Workflow W);
	public void saveWorkFlow(Workflow W);
	public List<Workflow> findAllWorkFlows(Boolean archive);
	public void removeWorkFlow(Workflow W);
	public Workflow findWorkFlowById(int id);
	public void removeWorkFlowById(int id);
	public Boolean existantWorkflow(int id);
	public List<Workflow> findCurrentWorkflows(Boolean archive);
	public List<Workflow> findWorkflowsbyType(Boolean archive, WFType type);
	List<Workflow> findWorkflowsbyCreateur(Boolean archive, int idCreateur);
	void archiverworkflow(int idWorkflow);
	void dearchiverworkflow(int idWorkflow);
}
