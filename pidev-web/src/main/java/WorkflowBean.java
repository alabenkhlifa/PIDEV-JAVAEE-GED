
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.esprit.pidev.persistance.*;

@ManagedBean
@RequestScoped
public class WorkflowBean {

	@EJB
	private WorkflowServiceLocal workflowServiceLocal;
	@EJB
	private DirecteurServiceLocal dSL;

	List<Workflow> workflows;
	private int DirecteurID;
	Date form_datelimite;
	Workflow workflow = new Workflow();

	public Date getForm_datelimite() {
		return form_datelimite;
	}

	public void setForm_datelimite(Date form_datelimite) {
		this.form_datelimite = form_datelimite;
	}

	public void setWorkflow(Workflow w) {
		workflow = w;
	}

	public List<Workflow> getWorkflows() {
		return workflows;
	}

	public void setWorkflows(List<Workflow> workflows) {
		this.workflows = workflows;
	}

	public int getDirecteurID() {
		return DirecteurID;
	}

	public void setDirecteurID(int directeurID) {
		DirecteurID = directeurID;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public String updateWorkflow(){
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int idworkflow = Integer.parseInt(req.getParameter("id"));
		if(!workflowServiceLocal.existantWorkflow(idworkflow))
			return "404.html";
		workflow = workflowServiceLocal.findWorkFlowById(idworkflow);
		return "";
	}
	
	public void createWorkflow(ActionEvent actionEvent) {
		Directeur d = dSL.findDirecteurById(DirecteurID);
		workflow.setCreateur(d);
		workflow.setStatus(WFStatus.EnAttente);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format = formatter.format(form_datelimite);
		System.out.println(format);
		System.out.println(form_datelimite);
		workflow.setDateLimite(form_datelimite);
		workflowServiceLocal.createWorkFlowFromDetach(workflow);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "WorkFlow Ajouté Avec Succés",
				"WorkFlow ID : " + workflow.getId());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	@PostConstruct
	public void Workflows() {
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		workflows = workflowServiceLocal.findAllWorkFlows();
		//if(workflowServiceLocal.existantWorkflow(Integer.parseInt(req.getParameter("id"))))
		if(null!=req.getParameter("id"))
		updateWorkflow();
	}
	
	public void UpWorkflow() throws IOException {
		workflowServiceLocal.saveWorkFlow(workflow);
		//refreshPage();
	}

	public void supprimerWorkflow(Workflow W) throws IOException {
		workflowServiceLocal.removeWorkFlow(W);
		refreshPage();
	}
	
	public void refreshPage() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}
}
