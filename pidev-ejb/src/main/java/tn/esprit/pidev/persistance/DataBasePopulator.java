package tn.esprit.pidev.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

//@Singleton
//@Startup
public class DataBasePopulator {

	@EJB
	WorkflowServiceLocal WFS;

	@EJB
	DirecteurServiceLocal DS;

	@EJB
	EmployeeServiceLocal ES;
	//

	public DataBasePopulator() {
	}

	@PostConstruct
	public void createData() {

		/**
		String ACCOUNT_SID = "ACf6bbc81a8c544e5a06fcc275cd39e21a";
		String AUTH_TOKEN = "48be1c82b0f20bcff11bca93f65855b4";

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new PhoneNumber("+21650280400"), new PhoneNumber("+15615373507"),
				"Test Twilio API for JAVA EE !! ").create();
		
//		System.out.println(message.getSid());
		 **/

//		Directeur directeur1 = new Directeur();
//		directeur1.setNom("Directeur 1");
//		directeur1.setPrenom("Directeur 1");
////
//		DS.createDirecteur(directeur1);
////
//		Employee employee1 = new Employee();
//		employee1.setNom("Employee 1");
//		employee1.setPrenom("Employee 1");
//		ES.createEmployee(employee1);
//		
//		List<Employee> participants = new ArrayList<Employee>() ;
//		participants.add(employee1);
////		participants = ES.getallEmployees();
//		Workflow workflow = new Workflow();
//		workflow.setArchive(false);
//		workflow.setParticipants(participants);
//		workflow.setCreateur(directeur1);
//		workflow.setPriorite(WFPriorite.Normale);
//		workflow.setStatus(WFStatus.EnCours);
//		workflow.setType(WFType.Facture);
//
//		WFS.createWorkFlow(workflow);
		Workflow w = new Workflow();
		w.setId(2);
		w.setArchive(true);
		WFS.saveWorkFlow(w);
		// System.out.println(workflow);
	}

}
