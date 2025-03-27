package client;

import entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//Before running this example, enable IDENTITY id generation strategy in Book entity
public class BatchingInsertsUsingIdentityStrategyClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();		
		
	    for (int i = 1; i <= 25; i++) {
	    	Book book = new Book("Title-" + i, "ISBN-" + i);
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