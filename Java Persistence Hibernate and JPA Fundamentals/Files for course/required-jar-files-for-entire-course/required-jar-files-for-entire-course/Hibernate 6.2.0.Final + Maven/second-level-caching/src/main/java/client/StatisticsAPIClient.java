package client;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StatisticsAPIClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");	
		
		Statistics stats = emf.unwrap(SessionFactory.class).getStatistics();
		stats.setStatisticsEnabled(true);
		
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		 
		Guide guide1 = em1.find(Guide.class, 2L);
		
		em1.getTransaction().commit();
		em1.close(); 
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();

		Guide guide2 = em2.find(Guide.class, 2L);
		
		em2.getTransaction().commit();		
		em2.close(); 
		
		System.out.println(stats.getEntityStatistics("entity.Guide"));	

	}
}














