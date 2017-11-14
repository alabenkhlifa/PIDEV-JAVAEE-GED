package tn.esprit.pidev.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: WFHistory
 *
 */
@Entity
@Table(name = "WF_HISTORY")
public class WFHistory implements Serializable {

//	private WFHistoryPK pk;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="WFHISTORY_ID")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "document_fk")
	private Document document;

	@ManyToOne
	@JoinColumn(name = "workflow_fk")
	private Workflow workflow;

	@ManyToOne
	@JoinColumn(name = "employee_fk")
	private Employee employee;

	private String action;
	
	private Date date = new Date();


	private static final long serialVersionUID = 1L;

	public WFHistory() {

	}

	public WFHistory(Document document, Workflow workflow, Employee employee) {
//		this.pk.setDocumentid(document.getId());
//		this.pk.setWorkflowid(workflow.getId());
		this.document = document;
		this.workflow = workflow;
		this.employee = employee;
	}

//	@EmbeddedId
//	public WFHistoryPK getPk() {
//		if (pk == null) {
//			pk = new WFHistoryPK();
//		}
//		return pk;
//	}

//	public void setPk(WFHistoryPK pk) {
//		this.pk = pk;
//	}

	
	
	public Document getDocument() {
		return document;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	
	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((workflow == null) ? 0 : workflow.hashCode());
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
		WFHistory other = (WFHistory) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (workflow == null) {
			if (other.workflow != null)
				return false;
		} else if (!workflow.equals(other.workflow))
			return false;
		return true;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
