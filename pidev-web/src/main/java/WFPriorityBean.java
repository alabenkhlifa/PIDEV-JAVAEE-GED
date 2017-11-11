import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.pidev.persistance.WFPriorite;

@ManagedBean
@ApplicationScoped
public class WFPriorityBean {

	public WFPriorite[] getPriorities(){
		return WFPriorite.values();
	}
}
