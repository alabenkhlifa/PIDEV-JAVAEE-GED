package tn.esprit.pidev.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Customer extends User implements Serializable {

	private static final long serialVersionUID = -1100346515700490749L;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private Date birthDate;

	public Customer() {
	}

	public Customer(String login, String password, String email,
			String firstname, String lastname, String phoneNumber,
			Date birthDate) {
		super(firstname,lastname,email,login,null,password,phoneNumber,null,null,null,null);
		this.birthDate = birthDate;
	}
	
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
