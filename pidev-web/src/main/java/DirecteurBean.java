import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.pidev.persistance.Directeur;
import tn.esprit.pidev.persistance.DirecteurServiceLocal;

@ManagedBean
@SessionScoped
public class DirecteurBean {

	@EJB
	private DirecteurServiceLocal DSL ;
	private String Pren ;
	List<Directeur> LD ;
	public DirecteurBean() {
	}
	@PostConstruct
	public void getalldirecteur(){
		LD = DSL.getalldirecteur();
	}
	public List<Directeur> getLD() {
		return LD;
	}
	public void setLD(List<Directeur> lD) {
		LD = lD;
	}
	public String getPren() {
		return Pren;
	}
	public void setPren(String pren) {
		Pren = pren;
	}
	
	
	
	

}
