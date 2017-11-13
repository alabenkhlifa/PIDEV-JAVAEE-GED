package tn.esprit.pidev.persistance;

import java.util.ArrayList;
import java.util.List;

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
	@Override
	public List<Employee> getallEmployees(){
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	@Override
	public List<Employee> getlistemployeebyids(List<Integer> listids){
		List<Employee> listemployees = new ArrayList<Employee>();
		for (Integer idemp : listids){
		Employee E = em.createQuery("select e from Employee e where e.id=:idemp", Employee.class).setParameter("idemp", idemp).getSingleResult();
		listemployees.add(E);
		}
		return listemployees;
	}

}
