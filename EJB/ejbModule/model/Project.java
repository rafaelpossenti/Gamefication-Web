package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Project.findAll",query="SELECT c FROM Project c")
public class Project{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int     id; 
    private String  name;
    private String  description; 
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
    
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Project)) {
			throw new IllegalArgumentException();
		}
		return ((Project) obj).getId() == id;
	}
    
	@Override
	public int hashCode() {
		return Integer.valueOf(id).hashCode();
	}
		
}
