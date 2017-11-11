package tn.esprit.pidev.persistance;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface WorkflowServiceRemote {
	public void createWorkFlow(Workflow W);
	public void saveWorkFlow(Workflow W);
	public List<Workflow> findAllWorkFlows();
	public void removeWorkFlow(Workflow W);
	public Workflow findWorkFlowById(int id);
	public void removeWorkFlowById(int id);
	public Boolean existantWorkflow(int id);
}
