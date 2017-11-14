package tn.esprit.pidev.persistance;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

@Local
public interface DocumentServiceLocal {

	void createDocument(Document d);

	List<Document> getallDocuments();

	List<Document> getlistdocumentbyids(List<Integer> listids);

	List<Document> getdocumentsbyworkflow(int workflowid);

}
