package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Task;
import util.JPAUtil;

/**
 * Session Bean implementation class GeneralRegister
 */
@Stateless
@LocalBean
public class GeneralRegister {

	//
	
	
	private EntityManager em = new JPAUtil().getEntityManager();
	
	/**
     * Default constructor. 
     */
    public GeneralRegister() {
        // TODO Auto-generated constructor stub
    }
    
    public Task createSampleTask(){
    	   Task task = new Task();
    	   task.setName("Integração com PDV NOVA ");
   		   task.setDescription("Integrar nosso ERP com o modulo de terceiros do PDV - testes");
   		   task.setPoint(45);
   		   task = em.merge(task);
    	   return task;
    }
    
    public void remove(Task task){
    	 em.remove(em.merge(task));
    }
    
    public Task findOrUpdate(Task task){
    	Task result = em.merge(task); 
    	return result;
    }
    
    public List<Task> listTasks(){
    	Query query = em.createNamedQuery("Task.findAll");
        return  query.getResultList();	
    }
    
    public Task findTaskById(Long id){
    	return em.find(Task.class, id);
    }
    
    public Task findTaskByName(String name){
    	Query query = em.createQuery("SELECT c FROM Task c WHERE c.name = :name");
    	query.setParameter("name", name);
    	return (Task) query.getSingleResult();
    }
    

}
