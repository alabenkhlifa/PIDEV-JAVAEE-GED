package tn.esprit.pidev.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: WFHistoryPK
 *
 */
@Embeddable
public class WFHistoryPK implements Serializable {

	private Integer workflowid;

	private Integer documentid;

	private Date date;

	private static final long serialVersionUID = 1L;

	public WFHistoryPK() {

	}

	@Column(name = "workflow_fk")
	public Integer getWorkflowid() {
		return this.workflowid;
	}

	public void setWorkflowid(Integer workflowID) {
		this.workflowid = workflowID;
	}

	@Column(name = "document_fk")
	public Integer getDocumentid() {
		return this.documentid;
	}

	public void setDocumentid(Integer documentID) {
		this.documentid = documentID;
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((documentid == null) ? 0 : documentid.hashCode());
		result = prime * result + ((workflowid == null) ? 0 : workflowid.hashCode());
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
		WFHistoryPK other = (WFHistoryPK) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (documentid == null) {
			if (other.documentid != null)
				return false;
		} else if (!documentid.equals(other.documentid))
			return false;
		if (workflowid == null) {
			if (other.workflowid != null)
				return false;
		} else if (!workflowid.equals(other.workflowid))
			return false;
		return true;
	}

}
