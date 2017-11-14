import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator(value="dateValidator")
public class DateValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		
		 Date datelimite = (Date)arg2;
		 Instant maintenant = Instant.now(); //date d'aujourdhui
		 Instant avant1jours = maintenant.minus(Duration.ofDays(1));
		 Date hier = Date.from(avant1jours);
		 if(datelimite.before(hier)){
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"La date limite doit etre superieur a la date d'aujourd'hui","");
	            throw new ValidatorException(msg);
	        }
		
	}

}
