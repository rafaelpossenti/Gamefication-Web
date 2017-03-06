package managedbeans;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ejb.PersistenceServiceEJB;

import model.Staff;

@ManagedBean
@SessionScoped
public class StaffManagedBean {
	 
	@EJB
	private PersistenceServiceEJB ejb;
	
	private Staff currentStaff = new Staff(); 
	
	private List staffList ;
	
	private FacesContext context;
	NavigationHandler navHandler;
	
	
	public Staff getCurrentStaff() {
		return currentStaff;
	}

	public void setCurrentStaff(Staff currentStaff) {
		this.currentStaff = currentStaff;
	}


	
	
	public List<Staff> getStaffList() {
		if (staffList == null){
			staffList = ejb.findAll("Staff.findAll");
		}
		return staffList;
	}

    public void setStaffList(List staffList) {
		this.staffList = staffList;
	}
    
    public String refresh(){
    	staffList = ejb.findAll("Staff.findAll");
    	return null;
	}
      
    
    public String create(){
        System.out.println("FOI--->");
    	currentStaff = new Staff();
    	return "edit";
    }
    
    public void save(){
    	ejb.save(currentStaff);
    	context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Registro Salvo!", "Nome: " + currentStaff.getName() ));
    	staffList = null;
    	currentStaff = new Staff();
    	navHandler = context.getApplication().getNavigationHandler();
    	navHandler.handleNavigation(context, null, "listStaff");
    }
    
    public String saveAndNew(){
    	ejb.save(currentStaff);
    	context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Registro Salvo!", "Nome: " + currentStaff.getName() ));
    	staffList = null;
    	currentStaff = new Staff();
    	return "staff";
    }
    
    public String delete(){
        ejb.delete(currentStaff);
        staffList = ejb.findAll("Staff.findAll");
    	currentStaff = new Staff();
    	return "listStaff";
    }
        
    public void setSelectedStaff(Staff currentStaff) {
        this.currentStaff = currentStaff;
    }
    	
}
