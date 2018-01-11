package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.persistance.Category;
import tn.esprit.pidev.persistance.Document;

@Remote
public interface FolderServiceLocal {
	void createDocument(Document document);
	void saveDocument(Document document);
	Document findDocumentById(int id);
	void removeDocument(int document);
	List<Document> findAllDocuments();
	List<Document> findDocumentsByCategory(Category category);
	List<Document> findDocumentsByName(String titre);
	public void editDocument(Document f); 
	
	void createCategory(Category category);
	void saveCategory(Category category);
	Category findCategoryById(int id);
	void removeCategory(Category category);
	List<Category> findAllCategories();
	Category findCategoryByName(String name);
	
	byte[] findPictureByDocumenttName(String productName);
	public boolean updateDocument(Document c);
}
