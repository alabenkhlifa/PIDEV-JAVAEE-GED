package tn.esprit.pidev.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@XmlRootElement
public class Employee implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMP_ID")
	@XmlAttribute(name="EmployeeID")
	private Integer id;
	
	@Column(name="EMP_Nom")
	private String nom;
	
	@Column(name="EMP_Prenom")
	private String prenom;
	
	@Column(name="EMP_Dep")
	private DepartementEnum departement;
	
	@ManyToMany(mappedBy="participants")
	private List<Workflow> workflows;
	
	@OneToMany(mappedBy = "employee")
	private List<WFHistory> history;

	
	private static final long serialVersionUID = 1L;

	public Employee() {
		
	}   
	
	
	public DepartementEnum getDepartement() {
		return departement;
	}


	public void setDepartement(DepartementEnum departement) {
		this.departement = departement;
	}


	public List<Workflow> getWorkflows() {
		return workflows;
	}


	public void setWorkflows(List<Workflow> workflows) {
		this.workflows = workflows;
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
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Employee other = (Employee) obj;
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
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
   
}
