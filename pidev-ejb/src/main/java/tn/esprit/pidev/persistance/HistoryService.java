package tn.esprit.pidev.persistance;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class HistoryService implements HistoryServiceLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	public HistoryService() {
	}

	@Override
	public void createHistory(WFHistory histo) {
		//;
		em.createNativeQuery("INSERT INTO `wf_history` (`action`,`workflow_fk`) VALUES ('act', w)").setParameter("act",histo.getAction()).setParameter("w", histo.getWorkflow().getId()).executeUpdate();
	}
	@Override
	public void updateHistory(WFHistory histo){
		em.merge(histo);
	}
	
	@Override
	public List<WFHistory> getallhistory(){
		return em.createQuery("select h from WFHistory h", WFHistory.class).getResultList();
	}
}
