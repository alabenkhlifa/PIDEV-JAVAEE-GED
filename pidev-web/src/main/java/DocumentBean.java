import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.pidev.persistance.Document;
import tn.esprit.pidev.persistance.DocumentServiceLocal;

@ManagedBean
@RequestScoped
public class DocumentBean {
	@EJB
	DocumentServiceLocal DSL;
	List<Document> LD;
	public List<Document> getLD() {
		return LD;
	}
	public void setLD(List<Document> lD) {
		LD = lD;
	}
	public DocumentBean() {
	}
	@PostConstruct
	public void getalldocuments(){
		LD = DSL.getallDocuments();
	}
	public List<Document> getdocumentsbyid(List<Integer> listids){
		return DSL.getlistdocumentbyids(listids);
	}
}
