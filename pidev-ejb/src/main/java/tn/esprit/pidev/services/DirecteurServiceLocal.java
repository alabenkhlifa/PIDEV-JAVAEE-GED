package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.pidev.persistance.Directeur;

@Local
public interface DirecteurServiceLocal {

	public void createDirecteur(Directeur D);
	public List<Directeur> getalldirecteur();
	public Directeur findDirecteurById(int id);
}
