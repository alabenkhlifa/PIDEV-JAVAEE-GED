package tn.esprit.pidev.persistance;

import java.util.List;

import javax.ejb.Local;

@Local
public interface DirecteurServiceLocal {

	public void createDirecteur(Directeur D);
	public List<Directeur> getalldirecteur();
	public Directeur findDirecteurById(int id);
}
