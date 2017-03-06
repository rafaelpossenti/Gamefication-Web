package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class PersistenceServiceEJB
 */
@Stateless
@LocalBean
public class PersistenceServiceEJB {

	
	@PersistenceContext
	private EntityManager em; 
	
	
    public PersistenceServiceEJB() {
        //TODO Auto-generated constructor stub
    }

    public List findAll(String namedQuery){
    	Query query = em.createNamedQuery(namedQuery);
        return query.getResultList();
    }
    
    public <T> T findById(int id, Class<T> entityType){
    	return em.find(entityType, id);
    }
    
    public <T> T save(T entity){
    	//em.persist(entity);
    	System.out.println("Antes de salvo");
    	T result = em.merge(entity);
    	System.out.println("Depois de salvo");
        return result; //entity; 
	}
    
    public <T> void delete(T entity){
    	em.remove(em.merge(entity));
    }
    
    public List findAll(String namedQuery, int count, int start){
    	Query query = em.createNamedQuery(namedQuery);
    	query.setMaxResults(count);
    	query.setFirstResult(start);
        return query.getResultList();	
    }
    
    
}
