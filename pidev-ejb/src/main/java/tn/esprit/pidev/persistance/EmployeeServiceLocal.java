package tn.esprit.pidev.persistance;

import javax.ejb.Local;

@Local
public interface EmployeeServiceLocal {

	public void createEmployee(Employee e);
}
