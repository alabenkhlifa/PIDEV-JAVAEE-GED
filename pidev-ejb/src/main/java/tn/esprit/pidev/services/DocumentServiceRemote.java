package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.persistance.Document;

@Remote
public interface DocumentServiceRemote {

	void createDocument(Document d);

	List<Document> getallDocuments();

	List<Document> getlistdocumentbyids(List<Integer> listids);

	List<Document> getdocumentsbyworkflow(int workflowid);

	Document testEM();
	
	void addDoc(Document doc);
	
	void removeDoc(Document doc);
	
	void updateDoc(Document doc);

}
