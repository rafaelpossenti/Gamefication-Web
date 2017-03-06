package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@NamedQuery(name="Task.findAll",query="SELECT c FROM Task c")
public class Task {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String  name;
	private String  description;
	private String  difficulty; 
	private double  estimateHour;
	private int     point;
    private boolean alive;
    private String  historic; 
	
	
	@ManyToOne
	private Project project;
	
	@ManyToOne
	private Staff staff;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	public double getEstimateHour() {
		return estimateHour;
	}
	public void setEstimateHour(double estimateHour) {
		this.estimateHour = estimateHour;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public String getHistoric() {
		return historic;
	}
	public void setHistoric(String historic) {
		this.historic = historic;
	} 
	
			
}
