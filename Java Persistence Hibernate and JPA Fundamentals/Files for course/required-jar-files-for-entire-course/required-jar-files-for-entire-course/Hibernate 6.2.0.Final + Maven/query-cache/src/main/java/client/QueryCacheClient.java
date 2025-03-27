package client;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class QueryCacheClient {		
	@SuppressWarnings("unused")
	public static void main(String[] args) {		
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");	
				
				Statistics stats = emf.unwrap(SessionFactory.class).getStatistics();
				stats.setStatisticsEnabled(true);
				
				EntityManager em1 = emf.createEntityManager();
				em1.getTransaction().begin();
				 
				Guide guide1 = (Guide) em1.createQuery("select guide from Guide guide where guide.name = :name")
						  										  .setParameter("name", "Ian Lamb")
																  .setHint("org.hibernate.cacheable", true)											  
																  .getSingleResult();	
				
				em1.getTransaction().commit();
				em1.close(); 
				
				EntityManager em2 = emf.createEntityManager();
				em2.getTransaction().begin();
				
				Guide guide2 = (Guide) em2.createQuery("select guide from Guide guide where guide.name = :name")
						  										  .setParameter("name", "Ian Lamb")
																  .setHint("org.hibernate.cacheable", true)
																  .getSingleResult();	
				
				em2.getTransaction().commit();		
				em2.close(); 

	}
}
