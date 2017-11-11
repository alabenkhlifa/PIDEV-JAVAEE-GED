import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.pidev.persistance.WFStatus;

@ManagedBean
@ApplicationScoped
public class wFStatusBean {

	public WFStatus[] getstatus(){
		return WFStatus.values();
	}
}

