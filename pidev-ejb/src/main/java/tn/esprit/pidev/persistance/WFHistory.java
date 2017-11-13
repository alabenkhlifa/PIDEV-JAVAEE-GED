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

	private WFHistoryPK pk;

	private Document document;

	private Workflow workflow;
	
	private Employee employee;

	private String action;
	
	private Date date = new Date();


	private static final long serialVersionUID = 1L;

	public WFHistory() {

	}

	public WFHistory(WFHistoryPK pk, Document document, Workflow workflow, Employee employee) {
		this.pk.setDocumentid(document.getId());
		this.pk.setWorkflowid(workflow.getId());
		this.document = document;
		this.workflow = workflow;
		this.employee = employee;
	}

	@EmbeddedId
	public WFHistoryPK getPk() {
		if (pk == null) {
			pk = new WFHistoryPK();
		}
		return pk;
	}

	public void setPk(WFHistoryPK pk) {
		this.pk = pk;
	}

	@ManyToOne
	@JoinColumn(name = "document_fk")
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@ManyToOne
	@JoinColumn(name = "workflow_fk")
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
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
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
	
	@ManyToOne
	@JoinColumn(name = "employee_fk")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
