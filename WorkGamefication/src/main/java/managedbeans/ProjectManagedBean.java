package managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import ejb.PersistenceServiceEJB;
import model.Project;;

@ManagedBean
@SessionScoped
public class ProjectManagedBean {

	@EJB
	private PersistenceServiceEJB ejb;

	
	private Project currentProject = new Project();

	private FacesContext context;

	private List projectList;

	public Project getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(Project currentProject) {
		this.currentProject = currentProject;
	}

	public List<Project> getProjectList() {
		if (projectList == null) {
			projectList = ejb.findAll("Project.findAll");
		}
		return projectList;
	}

	public void setProjectList(List projectList) {
		this.projectList = projectList;
	}

	public String refresh() {
		projectList = ejb.findAll("Project.findAll");
		return null;
	}

	public int getLengthListProject() {
		return projectList.size();
	}

	public String create() {
		currentProject = new Project();
		return "edit";
	}

	public String save() {
		ejb.save(currentProject);
		context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Registro Salvo!", "Projeto: " + currentProject.getName()));
		projectList = null;
		currentProject = new Project();
		RequestContext.getCurrentInstance().reset("form:Projeto");
		return "project";
	}

	public String cancel() {
		currentProject = new Project();
		return "project";
	}

	public String delete() {
		ejb.delete(currentProject);
		projectList = ejb.findAll("Project.findAll");
		return "listProject";
	}

	public void setSelectedProject(Project currentProject) {
		this.currentProject = currentProject;
	}


}
