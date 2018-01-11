package tn.esprit.pidev.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.pidev.persistance.Category;
import tn.esprit.pidev.persistance.Document;

@Stateless
public class FolderService implements FolderServiceLocal{
	
	@PersistenceContext
	private EntityManager em;

	public FolderService() {
	}

	@Override
	public void createDocument(Document document) {
		em.persist(document);
	}

	@Override
	public void saveDocument(Document doc) {
		em.merge(doc);
	}
	
	

	@Override
	public Document findDocumentById(int id) {
		return em.find(Document.class, id);
	}

	@Override
	public void removeDocument(int idDocument) {
		Document e = em.find(Document.class,idDocument);
		em.remove(e);
	}

	
	@Override
	public List<Document> findAllDocuments() {
		return em.createQuery("select d from Document d", Document.class)
				.getResultList();
	}

	@Override
	public List<Document> findDocumentsByCategory(Category category) {
		return  em.createQuery("select d from Document d where d.Document=:c",
						Document.class).setParameter("c", category)
				.getResultList();	}

	@Override
	public void createCategory(Category category) {
		em.persist(category);		
	}

	@Override
	public void saveCategory(Category category) {
		em.merge(category);		
	}

	@Override
	public Category findCategoryById(int id) {
		return em.find(Category.class, id);
	}

	@Override
	public void removeCategory(Category category) {
		em.remove(em.merge(category));
		
	}

	@Override
	public List<Category> findAllCategories() {
		return em.createQuery("select c from Category c", Category.class)
				.getResultList();
	}
	public byte[] findPictureByDocumenttName(String productName) {
		byte[] picture = null;
		TypedQuery<byte[]> query = em.createQuery(
				"select p.picture from Document p where p.name=:x", byte[].class);
		query.setParameter("x", productName);
		try {
			picture = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO,
					"no picture");
		}
		return picture;

	}
	
	public Category findCategoryByName(String name) {
		Category found = null;
		TypedQuery<Category> query = em.createQuery(
				"select c from Category c where c.name=:x", Category.class);
		query.setParameter("x", name);
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO,
					"no category with name=" + name);
		}
		return found;
	}

	@Override
	public List<Document> findDocumentsByName(String titre) {
		return em.createQuery("select a from Document a where a.titleDocument like :titre ", Document.class)
				.setParameter("titre", "%"+titre+"%").getResultList();
	}

	@Override
	public void editDocument(Document f) {
		
			em.merge(f);
			
	}
	@Override
	public boolean updateDocument(Document c) {
		em.merge(c);
		System.out.println("modifié");
		return true;
	}
}