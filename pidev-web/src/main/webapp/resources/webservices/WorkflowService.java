import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.pidev.services.WorkflowServiceLocal;
import tn.esprit.pidev.services.WorkflowServiceRemote;

@Stateless
@Path("/workflow")
public class WorkflowService {
	
	@EJB
	WorkflowServiceRemote wSR ;
	public WorkflowService (){
		try{
		InitialContext ctx=new InitialContext();
		remote = (EmployeeServiceRemote) ctx.lookup("java:global/pidev-ear/pidev-ejb/EmployeeService!tn.esprit.pidev.services.EmployeeServiceRemote");
		}
		catch(NamingException ne) 
        {
          System.out.println("n[MyRestService]NamingException: "+ne);
          ne.printStackTrace();
        }
	}
	@GET
	public Response getAllWorkflows(){
		return Response.ok().entity("ala").build();
	}

}
