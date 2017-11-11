package tn.esprit.pidev.persistance;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class DirecteurService implements DirecteurServiceLocal{

	@PersistenceContext
	private EntityManager em;
	
	public DirecteurService(){
	}
	
	@Override
	public void createDirecteur(Directeur D) {
		em.persist(D);
	}
	@Override
	public List<Directeur> getalldirecteur() {
		return em.createQuery("select d from Directeur d", Directeur.class).getResultList();
	}
	
	public Directeur findDirecteurById(int id) {
		return em.find(Directeur.class, id);
	}
}
