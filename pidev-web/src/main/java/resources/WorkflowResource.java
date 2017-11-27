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
import tn.esprit.pidev.persistance.WFPriorite;
import tn.esprit.pidev.persistance.Workflow;
import tn.esprit.pidev.services.DirecteurService;
import tn.esprit.pidev.services.DirecteurServiceLocal;
import tn.esprit.pidev.services.DocumentService;
import tn.esprit.pidev.services.DocumentServiceLocal;
import tn.esprit.pidev.services.DocumentServiceRemote;
import tn.esprit.pidev.services.WorkflowServiceLocal;

@Path("/")
@RequestScoped
public class WorkflowResource {
	
	@EJB 
	WorkflowServiceLocal wSL;
	@EJB
	DocumentServiceLocal dSL ;
	@EJB
	DocumentServiceRemote dSR ;
	@EJB
	DirecteurServiceLocal dirSL;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response test() {
		return Response.ok("test").build();
	}
	@Path("m1")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response testjson(){
		Workflow w = wSL.findWorkFlowById(1);
//		w.setCreateur(dirSL.findDirecteurById(1));
//		ArrayList<Document> docs = new ArrayList<>(dSL.getallDocuments());
		return Response.status(Status.OK).entity(w).build();
	}
	@Path("m2")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response testjson2(){
		ArrayList<Directeur> LD = new ArrayList<Directeur>(dirSL.getalldirecteur());
		return Response.status(Status.OK).entity(LD).build();
	}
	
	@Path("m3")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response testjson3(){
		ArrayList<Workflow> workflows = new ArrayList<>(wSL.findAllWorkFlows(false));
		
		return Response.status(Status.OK).entity(workflows).build();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createWorkflow(Workflow w){
		wSL.createWorkFlow(w);
		return Response.status(Status.CREATED).build();
	}
	@DELETE
	@Path("{id}")
	@Produces("text/plain")
	public Response deleteWorkflow(@PathParam("id") int id){
		wSL.removeWorkFlowById(id);
		return Response.status(Status.OK).build();
	}


}
