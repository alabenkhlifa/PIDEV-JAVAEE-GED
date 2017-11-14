import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.pidev.persistance.Workflow;
import tn.esprit.pidev.services.WorkflowServiceLocal;

@ManagedBean(name = "wfFilterView")
@ViewScoped
public class workflowsfilter implements Serializable {

	private List<Workflow> workflows;

	private List<Workflow> filteredworkflows;

	@EJB
	private WorkflowServiceLocal WSL;
	
	@PostConstruct
    public void init() {
        workflows = WSL.findAllWorkFlows(false);
    }
}
