package tn.esprit.pidev.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.annotation.XmlRootElement;

import tn.esprit.pidev.persistance.Document;

@Stateless
//@LocalBean
public class DocumentService implements DocumentServiceLocal,DocumentServiceRemote {

	@PersistenceContext
	private EntityManager em;
	@EJB
	private WorkflowServiceLocal WSL ;
	
	public DocumentService() {
		
	}

	@Override
	public void createDocument(Document d) {
		// TODO Auto-generated method stub
		em.persist(d);
	}
	@Override
	public Document testEM(){
		Document d = new Document();
		d.setId(10);
		d.setNom("test du entity manager");
		d.setTaille(100);
		return d;
	}
	
	@Override
	public List<Document> getallDocuments(){
		return em.createQuery("select d from Document d", Document.class).getResultList();
	}
	@Override
	public List<Document> getlistdocumentbyids(List<Integer> listids){
		List<Document> listdocuments = new ArrayList<Document>();
		for (Integer iddoc : listids){
			Document d = em.createQuery("select d from Document d where d.id=:iddoc", Document.class).setParameter("iddoc", iddoc).getSingleResult();
		listdocuments.add(d);
		}
		return listdocuments;
	}
	@Override
	public List<Document> getdocumentsbyworkflow(int workflowid){
		List<Integer> LI = em.createNativeQuery("SELECT w.id FROM `wf_doc` w WHERE `WF_ID` =:wid",Document.class).setParameter("wid", workflowid).getResultList();
		return getlistdocumentbyids(LI);
		
	}

}
