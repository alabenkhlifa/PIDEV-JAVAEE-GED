package tn.esprit.pidev.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategory;
	@Column(unique=true)
	private String categoryName;
	@OneToMany(mappedBy = "category")
	private List<Document> documents;
	
	
	public Category() {
	}
	

	public int getId() {
		return this.idCategory;
	}
	
	public String getName() {
		return this.categoryName;
	}
	public void setId(int idCategory) {
		this.idCategory = idCategory;
	}
	public void setName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	public void addDocuemnt(Document document){
		this.getDocuments().add(document);
		document.setCategory(this);
	}
//	@PreRemove
//	public void preRemove(){
//		for(Document p:documents)
//			p.setCategory(null);
//	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		return true;
	}
	
	
	
   
}
