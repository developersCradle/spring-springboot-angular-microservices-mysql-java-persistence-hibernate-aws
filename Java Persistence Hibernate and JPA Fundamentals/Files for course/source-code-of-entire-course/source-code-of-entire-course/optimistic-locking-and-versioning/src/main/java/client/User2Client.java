package client;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class User2Client {	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();		
		
		Guide guide = em1.find(Guide.class, 2L);				
	
		em1.getTransaction().commit();
		em1.close();	

		guide.setSalary(4000);
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		
		Guide mergedGuide = em2.merge(guide);
		
		em2.getTransaction().commit();
		em2.close();	
		
	}
}
