package converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ejb.PersistenceServiceEJB;
import model.Staff;

@FacesConverter(value = "StaffConverter")
public class StaffConverter implements Converter {

	@EJB
	private PersistenceServiceEJB ejb;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return ejb.findById(Integer.valueOf(value), Staff.class);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return    Integer.toString( ((Staff) value).getId() ) ;
	}
	
}
