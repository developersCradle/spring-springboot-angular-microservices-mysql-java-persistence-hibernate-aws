package client;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.Persistence;

public class User1Client {	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();		
		
		Guide guide = em1.find(Guide.class, 2L);				
	
		em1.getTransaction().commit();
		em1.close();	

		guide.setSalary(3000);
		
		EntityManager em2 = emf.createEntityManager();
		EntityTransaction txn2 = em2.getTransaction();
		try {
			txn2.begin();
			
			Guide mergedGuide = em2.merge(guide);
			
			txn2.commit();
		} catch (OptimisticLockException ole) {
			if(txn2 != null) { 
				txn2.rollback(); 
				System.err.println("The guide was updated by some other user while you were doing interesting things.");
			}
			ole.printStackTrace();
		} finally {
			if(em2 != null) { em2.close(); }
		}	
	}
}
