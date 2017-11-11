import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.pidev.persistance.WFType;

@ManagedBean
@ApplicationScoped
public class WFTypeBean {

	public WFType[] gettypes(){
		return WFType.values();
	}
}
