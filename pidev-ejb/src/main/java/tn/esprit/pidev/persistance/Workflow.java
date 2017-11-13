package tn.esprit.pidev.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Workflow
 *
 */
@Entity
public class Workflow implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WF_ID")
	private Integer id;
	
	@Column(name = "WF_Date_Creation")
	@Basic(optional = true)
	@Temporal(TemporalType.TIMESTAMP)
	//@CreationTimestamp
	private Date dateCreation;
	
	@Column(name = "WF_Avant_Le",columnDefinition="DATE NULL")
	private Date dateLimite;

	@Column(name = "WF_est_Archive")
	private boolean archive;

	@Column(name = "WF_Status")
	@Enumerated(EnumType.STRING)
	private WFStatus status;

	@Column(name = "WF_priorite")
	@Enumerated(EnumType.STRING)
	// private WFPriorite prio;
	private WFPriorite priorite;

	@Column(name = "WF_Type")
	@Enumerated(EnumType.STRING)
	private WFType type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CREATEUR_ID")
	private Directeur createur;

	@ManyToMany
	@JoinTable(name = "WF_EMP", joinColumns = @JoinColumn(name = "WF_ID", referencedColumnName = "WF_ID") , inverseJoinColumns = @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID") )
	private List<Employee> participants;

	@OneToMany(mappedBy = "workflow")
	private List<WFHistory> history;

	private static final long serialVersionUID = 1L;
	
	public Workflow() {
		this.dateCreation = new Date();
	}
	
	@Basic(optional = true)
	@Temporal(TemporalType.DATE)
	public Date getDateLimite() {
		return dateLimite;
	}



	public void setDateLimite(Date dateLimite) {
		this.dateLimite = dateLimite;
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

	
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public boolean getArchive() {
		return this.archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	public WFStatus getStatus() {
		return status;
	}

	public void setStatus(WFStatus status) {
		this.status = status;
	}

	public WFPriorite getPriorite() {
		return priorite;
	}

	public void setPriorite(WFPriorite priorite) {
		this.priorite = priorite;
	}
	
	@PrePersist
	private void onPersistCallback() {
	  this.dateCreation = new Date();
	}

	public WFType getType() {
		return type;
	}

	public void setType(WFType type) {
		this.type = type;
	}

	public Directeur getCreateur() {
		return createur;
	}

	public void setCreateur(Directeur createur) {
		this.createur = createur;
	}

	public List<Employee> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Employee> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "Workflow [id=" + id + ", dateCreation=" + dateCreation + ", archive=" + archive + ", status=" + status
				+ ", priorite=" + priorite + ", type=" + type + ", createur=" + createur + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createur == null) ? 0 : createur.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Workflow other = (Workflow) obj;
		if (createur == null) {
			if (other.createur != null)
				return false;
		} else if (!createur.equals(other.createur))
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	protected Workflow merge(Workflow other) {
	    setArchive(other.getArchive());
	    setCreateur(other.getCreateur());
	    setDateCreation(other.getDateCreation());
	    setDateLimite(other.getDateLimite());
	    setId(other.getId());
	    setPriorite(other.getPriorite());
	    setStatus(other.getStatus());
	    setType(other.getType());
	    setParticipants(other.getParticipants());
	    return this;
	}

}
