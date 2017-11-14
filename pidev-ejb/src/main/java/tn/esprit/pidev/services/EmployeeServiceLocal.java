package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.pidev.persistance.Employee;

@Local
public interface EmployeeServiceLocal {

	public void createEmployee(Employee e);

	List<Employee> getallEmployees();

	List<Employee> getlistemployeebyids(List<Integer> listids);
}
