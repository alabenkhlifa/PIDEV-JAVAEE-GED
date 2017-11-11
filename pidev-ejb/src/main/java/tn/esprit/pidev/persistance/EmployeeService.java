package tn.esprit.pidev.persistance;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class EmployeeService implements EmployeeServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
	public EmployeeService() {
		
	}

	@Override
	public void createEmployee(Employee e) {
		// TODO Auto-generated method stub
		em.persist(e);
	}

}
