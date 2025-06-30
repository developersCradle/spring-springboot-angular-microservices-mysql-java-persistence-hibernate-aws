package client;

import java.util.List;

import entity.CustomerOrderSummary;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CustomerOrderSummaryClient {
	public static void main(String[] args) {
		
		//[BEGIN: Adding data to student and guide tables]
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
    	
		// Query the view
        List<CustomerOrderSummary> summaries = em.createQuery(
        																								"SELECT cos FROM CustomerOrderSummary cos", 
        																								CustomerOrderSummary.class
        																							  )
        																							  .getResultList();

        // Print results
        summaries.forEach(System.out::println);

		em.getTransaction().commit();
		em.close();	
		
		//[END: Adding data to student and guide tables]
	}

}
