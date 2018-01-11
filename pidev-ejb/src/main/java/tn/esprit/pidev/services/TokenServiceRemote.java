package tn.esprit.pidev.services;

import javax.ejb.Local;

import tn.esprit.pidev.persistance.*;
@Local
public interface TokenServiceRemote {
	public void setToken(String tokenValue, User user);
	public User getUser(String tokenValue);
	public Token find(String tokenValue);
	public Token find(User u);
	public void save(Token token);
	public void disableToken(User u) throws Exception;
}
