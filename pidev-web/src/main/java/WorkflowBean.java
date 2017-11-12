
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
	List<Workflow> workflowsarchives;
	private int DirecteurID;
	Date form_datelimite;
	Workflow workflow = new Workflow();
	
	public List<Workflow> getWorkflowsarchives() {
		return workflowsarchives;
	}

	public void setWorkflowsarchives(List<Workflow> workflowsarchives) {
		this.workflowsarchives = workflowsarchives;
	}

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

	//mch kémla 
	public String updateWorkflow(){
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int idworkflow = Integer.parseInt(req.getParameter("id"));
		if(!workflowServiceLocal.existantWorkflow(idworkflow))
			return "404.html";
		workflow = workflowServiceLocal.findWorkFlowById(idworkflow);
		return "";
	}
	
	//Success
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
		workflows = workflowServiceLocal.findAllWorkFlows(false);
		workflowsarchives = workflowServiceLocal.findAllWorkFlows(true);
		//if(workflowServiceLocal.existantWorkflow(Integer.parseInt(req.getParameter("id"))))
		if(null!=req.getParameter("id"))
		updateWorkflow();
	}
	
	public void UpWorkflow() throws IOException {
		workflowServiceLocal.saveWorkFlow(workflow);
		//refreshPage();
	}

	//Success
	public void supprimerWorkflow(Workflow W) throws IOException {
		workflowServiceLocal.removeWorkFlow(W);
		refreshPage();
	}
	
	//Success
	public void refreshPage() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}

	public void CurrentWorkflows(){
		workflows = workflowServiceLocal.findCurrentWorkflows(false);
	}
	
	public void WorkflowsBytype(WFType type){
		workflows = workflowServiceLocal.findWorkflowsbyType(false,type);
	}
	
	public void WorkflowsarchivesBytype(WFType type){
		workflowsarchives = workflowServiceLocal.findWorkflowsbyType(true,type);
	}
	
	public void WorkflowsByStatus(WFStatus status){
		workflows = workflowServiceLocal.findWorkflowsbyStatus(false,status);
	}
	
	public void WorkflowsarchivesByStatus(WFStatus status){
		workflowsarchives = workflowServiceLocal.findWorkflowsbyStatus(true,status);
	}
	
	public void WorkflowsByCreateur(int idc){
		workflows = workflowServiceLocal.findWorkflowsbyCreateur(false,idc);
	}
	
	public void WorkflowsarchivesByCreateur(int idc){
		workflowsarchives = workflowServiceLocal.findWorkflowsbyCreateur(true,idc);
	}
	
	public void allWorkflows(){
		workflows = workflowServiceLocal.findAllWorkFlows(false);
	}
	
	public void allarchivedWorkflows(){
		workflows = workflowServiceLocal.findAllWorkFlows(true);
	}
	
	public void archiverWorkflow(int idWork){
		workflowServiceLocal.archiverworkflow(idWork);
		allWorkflows();
	}
	
	public void dearchiverWorkflow(int idWork){
		workflowServiceLocal.dearchiverworkflow(idWork);
		try {
			refreshPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
