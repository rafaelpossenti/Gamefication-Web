package managedbeans;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import ejb.PersistenceServiceEJB;
import model.Project;
import model.Staff;
import model.Task;


@ManagedBean
@SessionScoped
public class TaskManagedBean {
	
	@EJB
	private PersistenceServiceEJB ejb;
	
	private Task  currentTask  = new Task();   
	 
	private FacesContext context;
	
	private List taskList;
	 
	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}

	public PersistenceServiceEJB getEjb() {
		return ejb;
	}

	public void setEjb(PersistenceServiceEJB ejb) {
		this.ejb = ejb;
	}

	public List<Task> getTaskList() {
		if (taskList == null){
			taskList = ejb.findAll("Task.findAll");
		}
		return taskList;
	}

    public void setTaskList(List taskList) {
		this.taskList = taskList;
	}
    
    public String refresh(){
    	taskList = ejb.findAll("Task.findAll");
    	return null;
	}
      
    public int getLengthListTask(){
    	 return  taskList.size();  
    }
    
    public String create(){
        currentTask = new Task();
    	return "edit";
    }
    
    public String save(){
    	currentTask.setAlive(false);
    	ejb.save(currentTask);
    	context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Registro Salvo!", "Tarefa: " + currentTask.getName() ));
    	taskList = null;
    	currentTask = new Task();
    	return "dashboard";
    }
    
    public String cancel(){
        currentTask = new Task();
    	return "dashboard";
    }
    
    public String delete(){
        ejb.delete(currentTask);
        taskList = ejb.findAll("Task.findAll");
    	return "listTask";
    }
    
    public void setSelectedStaff(Task currentTask) {
        this.currentTask = currentTask;
    }
    
    public void Finished(){
    	currentTask.setAlive(true);
    	Staff staff = currentTask.getStaff();
    	staff.setPoint(currentTask.getPoint() + staff.getPoint());
    	staff.setLevel(levelUp(staff));
    	ejb.save(currentTask);
    	ejb.save(staff);
    }
    
    public int levelUp(Staff staff){
    	if((staff.getPoint() >= 100) && (staff.getPoint() < 249))
    		return 1;
    	if((staff.getPoint() >= 250) && (staff.getPoint() < 399))
    		return 2;
    	if((staff.getPoint() >= 400) && (staff.getPoint() < 499))
    		return 3;
    	if((staff.getPoint() >= 500) && (staff.getPoint() < 759))
    		return 4;
    	if((staff.getPoint() >= 760) && (staff.getPoint() < 899))
    		return 5;
    	if((staff.getPoint() >= 900) && (staff.getPoint() < 1099))
    		return 6;
    	if((staff.getPoint() >= 1100) && (staff.getPoint() < 1299))
    		return 7;
    	if((staff.getPoint() >= 1300) && (staff.getPoint() < 1499))
    		return 8;
    	if((staff.getPoint() >= 1500) && (staff.getPoint() < 1999))
    		return 9;
    	if(staff.getPoint() >= 2000)
    		return 10;
    	return 0;
    }
    
}
