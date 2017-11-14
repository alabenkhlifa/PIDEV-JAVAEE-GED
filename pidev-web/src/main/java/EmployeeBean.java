import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.pidev.persistance.Employee;
import tn.esprit.pidev.services.EmployeeServiceLocal;

@ManagedBean
@RequestScoped
public class EmployeeBean {
	@EJB
	EmployeeServiceLocal ESL;
	List<Employee> LE;
	public List<Employee> getLE() {
		return LE;
	}
	public void setLE(List<Employee> lE) {
		LE = lE;
	}
	public EmployeeBean() {
	}
	@PostConstruct
	public void getallemployee(){
		LE = ESL.getallEmployees();
	}
	public List<Employee> getemployeesbyid(List<Integer> listids){
		return ESL.getlistemployeebyids(listids);
	}
	
}
