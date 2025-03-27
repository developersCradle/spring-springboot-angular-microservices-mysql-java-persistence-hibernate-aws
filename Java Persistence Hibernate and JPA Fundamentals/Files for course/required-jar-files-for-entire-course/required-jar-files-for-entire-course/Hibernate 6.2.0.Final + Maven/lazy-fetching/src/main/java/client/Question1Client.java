package client;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Question1Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();		
	
		Guide guide = em.find(Guide.class, 3L);
		em.detach(guide);		
		System.out.println(guide.getStudents().size());
		
		txn.commit();	
		em.close();         
	}
}



