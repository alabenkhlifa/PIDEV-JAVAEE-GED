package resources;

import java.util.ArrayList;
import java.util.Collections;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.primefaces.push.Status.STATUS;

import tn.esprit.pidev.persistance.Directeur;
import tn.esprit.pidev.persistance.Document;
import tn.esprit.pidev.persistance.Employee;
import tn.esprit.pidev.persistance.WFPriorite;
import tn.esprit.pidev.persistance.Workflow;
import tn.esprit.pidev.services.DirecteurService;
import tn.esprit.pidev.services.DirecteurServiceLocal;
import tn.esprit.pidev.services.DocumentService;
import tn.esprit.pidev.services.DocumentServiceLocal;
import tn.esprit.pidev.services.DocumentServiceRemote;
import tn.esprit.pidev.services.EmployeeServiceLocal;
import tn.esprit.pidev.services.WorkflowServiceLocal;

@Path("/")
@RequestScoped
public class WorkflowResource {

	@EJB
	WorkflowServiceLocal wSL;
	@EJB
	DocumentServiceLocal dSL;
	@EJB
	DocumentServiceRemote dSR;
	@EJB
	DirecteurServiceLocal dirSL;
	@EJB
	EmployeeServiceLocal eSL;

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkflowById(@PathParam("id") int id) {
		Workflow w = wSL.findWorkFlowById(id);
		if (null != w)
			return Response.status(Status.OK).entity(w).build();
		else
			return Response.status(Status.NOT_FOUND).build();
	}
	

	@Path("directeur")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDirectors() {
		ArrayList<Directeur> LD = new ArrayList<Directeur>(dirSL.getalldirecteur());
		return Response.status(Status.OK).entity(LD).build();
	}
	
	@Path("employee")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployees() {
		ArrayList<Employee> LE = new ArrayList<Employee>(eSL.getallEmployees());
		return Response.status(Status.OK).entity(LE).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAlldocuments() {
		ArrayList<Document> LDOC = new ArrayList<>(dSL.getallDocuments());
		return Response.status(Status.OK).entity(LDOC).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllWorkflows() {
		ArrayList<Workflow> workflows = new ArrayList<>(wSL.findAllWorkFlows(false));

		return Response.status(Status.OK).entity(workflows).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createWorkflow(Workflow w) {
		if (null != w) {
			wSL.createWorkFlow(w);
			return Response.status(Status.CREATED).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteWorkflowById(@PathParam("id") int id) {
		Workflow w = wSL.findWorkFlowById(id);
		if (null == w)
			return Response.status(Status.NOT_FOUND).entity("Le WorkFlow n'existe pas").build();
		else {
			wSL.removeWorkFlowById(id);
			return Response.status(Status.OK).build();
		}
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateWorkflow(Workflow newWorkflow){
		if(wSL.existantWorkflow(newWorkflow.getId())){
			wSL.saveWorkFlow(newWorkflow);
			return Response.status(Status.OK).entity("Updated").build();
		}
		else
			return Response.status(Status.NOT_FOUND).build();
	}

}
