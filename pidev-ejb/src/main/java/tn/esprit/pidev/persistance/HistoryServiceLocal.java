package tn.esprit.pidev.persistance;

import java.util.List;

import javax.ejb.Local;

@Local
public interface HistoryServiceLocal {

	public void createHistory(WFHistory histo);

	public List<WFHistory> getallhistory();

	public void updateHistory(WFHistory histo);

}
