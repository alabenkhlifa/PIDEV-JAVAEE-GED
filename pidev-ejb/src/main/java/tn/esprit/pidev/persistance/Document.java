package tn.esprit.pidev.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Document
 *
 */
@Entity
@XmlRootElement
public class Document implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute(name="DocumentID")
	private Integer id;
	@XmlElement
	private String nom;
	@XmlElement
	private double taille;
	@ManyToMany(mappedBy="documents",fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Workflow> workflows;
	@OneToMany(mappedBy = "document")
	@JsonIgnore
	private List<WFHistory> history ;
	@ManyToOne
	private User users;
	@ManyToOne
	@JoinColumn(name = "category_fk", nullable = true)
	private Category category;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] picture;
	private TypeDocument typeDocu;
	private String titleDocument;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAjoutDocument;
	private boolean signeeDocument; 
	private static final long serialVersionUID = 1L;

	public Document() {
		super();
		dateAjoutDocument = new Date();
	}   
	
	public List<Workflow> getWorkflows() {
		return workflows;
	}

	public void setWorkflows(List<Workflow> workflows) {
		this.workflows = workflows;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public TypeDocument getTypeDocu() {
		return typeDocu;
	}

	public void setTypeDocu(TypeDocument typeDocu) {
		this.typeDocu = typeDocu;
	}

	public String getTitleDocument() {
		return titleDocument;
	}

	public void setTitleDocument(String titleDocument) {
		this.titleDocument = titleDocument;
	}

	public Date getDateAjoutDocument() {
		return dateAjoutDocument;
	}

	public void setDateAjoutDocument(Date dateAjoutDocument) {
		this.dateAjoutDocument = dateAjoutDocument;
	}

	public boolean isSigneeDocument() {
		return signeeDocument;
	}

	public void setSigneeDocument(boolean signeeDocument) {
		this.signeeDocument = signeeDocument;
	}

	public List<WFHistory> getHistory() {
		return history;
	}

	public void setHistory(List<WFHistory> history) {
		this.history = history;
	}

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}   
	public double getTaille() {
		return this.taille;
	}
	public void setTaille(double taille) {
		this.taille = taille;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		long temp;
		temp = Double.doubleToLongBits(taille);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (Double.doubleToLongBits(taille) != Double.doubleToLongBits(other.taille))
			return false;
		return true;
	}
   
}
