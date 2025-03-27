package client;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CachingCollectionsClient {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");	
		
		Statistics stats = emf.unwrap(SessionFactory.class).getStatistics();
		stats.setStatisticsEnabled(true);
		
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		 
		Guide guide1 = em1.find(Guide.class, 2L);
		int size1 = guide1.getStudents().size();
		
		em1.getTransaction().commit();
		em1.close(); 
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();

		Guide guide2 = em2.find(Guide.class, 2L);
		int size2 = guide2.getStudents().size();
		
		em2.getTransaction().commit();
		em2.close(); 		

		//stats.getSecondLevelCacheStatistics(regionName) has been deprecated since Hibernate 5.3, so using stats.getDomainDataRegionStatistics(regionName) instead
		System.out.println("Student: " + stats.getDomainDataRegionStatistics("entity.Guide"));	
		System.out.println("Student: " + stats.getDomainDataRegionStatistics("entity.Student"));	
	}
}