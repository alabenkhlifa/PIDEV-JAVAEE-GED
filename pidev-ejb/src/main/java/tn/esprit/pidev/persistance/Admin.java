package tn.esprit.pidev.persistance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Admin extends User implements Serializable{
	
	private static final long serialVersionUID = -6762162980207739005L;
	
	private int adminLevel;
	
	public Admin() {
	}

	public Admin(String login, String password, String email,int adminLevel) {
		super(login, password,email);
		this.setAdminLevel(adminLevel);
	}

	public int getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(int adminLevel) {
		this.adminLevel = adminLevel;
	}

}
