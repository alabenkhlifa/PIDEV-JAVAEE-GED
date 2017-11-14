package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.pidev.persistance.WFHistory;

@Local
public interface HistoryServiceLocal {

	public void createHistory(WFHistory histo);

	public List<WFHistory> getallhistory();

	public void updateHistory(WFHistory histo);

}
