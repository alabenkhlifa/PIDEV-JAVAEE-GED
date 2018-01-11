package tn.esprit.pidev.services;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import tn.esprit.pidev.persistance.Document;

@Local
public interface DocumentServiceLocal {

	void createDocument(Document d);

	List<Document> getallDocuments();

	List<Document> getlistdocumentbyids(List<Integer> listids);

	List<Document> getdocumentsbyworkflow(int workflowid);

	Object testEM();

	void addDoc(Document doc);

	void removeDoc(Document doc);

	void updateDoc(Document doc);

}
