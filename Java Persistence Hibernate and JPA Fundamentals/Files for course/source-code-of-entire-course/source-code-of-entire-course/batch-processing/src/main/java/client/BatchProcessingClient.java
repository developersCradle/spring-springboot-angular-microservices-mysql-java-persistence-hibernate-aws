package client;

import entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BatchProcessingClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();		
		
	    for (int i = 1; i <= 25; i++) {
	    	Book book = new Book((long) i + 1, "Title-" + i, "ISBN-" + i);
	        em.persist(book);
	        
	        if (i % 5 == 0) {
	            em.flush();
	            em.clear();
	            System.out.println();
	        }
	    }
		
		em.getTransaction().commit();
		em.close();	
		
	}
}