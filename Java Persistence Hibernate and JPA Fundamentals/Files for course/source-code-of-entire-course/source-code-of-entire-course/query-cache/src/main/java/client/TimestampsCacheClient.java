package client;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TimestampsCacheClient {		
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
				System.out.println(guide1.getSalary());
				
				em1.getTransaction().commit();
				em1.close(); 

				EntityManager em2 = emf.createEntityManager();
				em2.getTransaction().begin();

				Guide guide2 = em2.find(Guide.class, 2L);
				guide2.setSalary(5000);
				
				em2.getTransaction().commit();		
				em2.close(); 			
				
				EntityManager em3 = emf.createEntityManager();
				em3.getTransaction().begin();

				Guide guide3 = (Guide) em3.createQuery("select guide from Guide guide where guide.name = :name")
																  .setParameter("name", "Ian Lamb")
																  .setHint("org.hibernate.cacheable", true)											  
																  .getSingleResult();	
				System.out.println(guide3.getSalary());
				
				em3.getTransaction().commit();		
				em3.close(); 
	}
}
