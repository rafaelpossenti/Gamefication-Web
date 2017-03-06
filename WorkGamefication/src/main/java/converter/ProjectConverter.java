package converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ejb.PersistenceServiceEJB;
import model.Project;

@FacesConverter(value = "ProjectConverter")
public class ProjectConverter implements Converter{
	@EJB
	private PersistenceServiceEJB ejb;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return ejb.findById(Integer.valueOf(value), Project.class);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return Integer.toString( ((Project) value).getId() ) ;
	}

}
