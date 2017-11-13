package tn.esprit.pidev.persistance;

import java.util.List;

import javax.ejb.Local;

@Local
public interface EmployeeServiceLocal {

	public void createEmployee(Employee e);

	List<Employee> getallEmployees();

	List<Employee> getlistemployeebyids(List<Integer> listids);
}
