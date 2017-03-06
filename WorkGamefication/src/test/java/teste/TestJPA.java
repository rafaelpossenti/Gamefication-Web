package teste;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.*;
import util.JPAUtil;

public class TestJPA {

	
	public static void main(String[] args) {
		
		
		
	    Task task = new Task();
	    task.setName("Integração com PDV 2 ");
		task.setDescription("Integrar nosso ERP com o modulo de terceiros do PDV - testes");
		task.setDifficulty("Fácil");
		task.setEstimateHour(15.0);
		task.setPoint(45);
		
		
		
//		EntityManager manager;  new JPAUtil().getEntityManager();

		//Staff staff = manager.find(Staff.class, 1);; 
		//System.out.println(staff.getName());
        
		
		
		
		/*
		manager.getTransaction().begin();
        manager.persist(task);
        manager.getTransaction().commit();
        manager.close();
		
		Staff staff = new Staff();
		staff.setName("Rodolfo");
		manager.getTransaction().begin();
		manager.persist(staff);
		manager.getTransaction().commit();
        manager.close();

        
        Team team = new Team();
		team.setName("Manutenção Fiscal");
		manager.getTransaction().begin();
		manager.persist(team);
		manager.getTransaction().commit();
        manager.close();
         */
		
		
		
		
	}
}
