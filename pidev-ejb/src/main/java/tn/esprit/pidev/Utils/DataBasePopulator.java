package tn.esprit.pidev.Utils;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.pidev.persistance.Directeur;
import tn.esprit.pidev.persistance.Document;
import tn.esprit.pidev.persistance.Employee;
import tn.esprit.pidev.services.DirecteurServiceLocal;
import tn.esprit.pidev.services.DocumentServiceLocal;
import tn.esprit.pidev.services.EmployeeServiceLocal;
import tn.esprit.pidev.services.WorkflowServiceLocal;



@Singleton
@Startup
public class DataBasePopulator {

	@EJB
	WorkflowServiceLocal WFS;
	
	@EJB
	DocumentServiceLocal DSL;

	@EJB
	DirecteurServiceLocal DS;

	@EJB
	EmployeeServiceLocal ES;
	//

	public DataBasePopulator() {
	}

	@PostConstruct
	public void createData() {

		Directeur directeur1 = new Directeur();
		directeur1.setNom("ben foulen1");
		directeur1.setPrenom("flen1");
		
		DS.createDirecteur(directeur1);
		
		Directeur directeur2 = new Directeur();
		directeur2.setNom("ben foulen2");
		directeur2.setPrenom("flen2");
		
		DS.createDirecteur(directeur2);
		
		Directeur directeur3 = new Directeur();
		directeur3.setNom("ben foulen3");
		directeur3.setPrenom("flen3");

		DS.createDirecteur(directeur3);

		Employee employee1 = new Employee();
		employee1.setNom("emp1");
		employee1.setPrenom("emp1");
		
		ES.createEmployee(employee1);
		
		Employee employee2 = new Employee();
		employee2.setNom("emp2");
		employee2.setPrenom("emp2");
		
		ES.createEmployee(employee2);
		
		Document document1 = new Document();
		document1.setNom("PDF");
		document1.setTaille(1000);
		
		DSL.createDocument(document1);
		
		Document document2 = new Document();
		document2.setNom("Word");
		document2.setTaille(800);
		
		DSL.createDocument(document2);
		
		Document document3 = new Document();
		document3.setNom("JGP");
		document3.setTaille(150);
		
		DSL.createDocument(document3);
		
		
		/*
		 * Under Construction *
		 */
		
//		Workflow w = WFS.findWorkFlowById(3);
//		w.setArchive(true);
//		WFS.saveWorkFlow(w);
//		WFHistory History = new WFHistory();
//		History.setWorkflow(w);
//		History.setAction("Status modifieee");
//		HistoryService HS = new HistoryService();
//		HS.createHistory(History);
	}

}
