package client;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CachingAssociationsClient {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");	
		
		Statistics stats = emf.unwrap(SessionFactory.class).getStatistics();
		stats.setStatisticsEnabled(true);
		
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		 
		Student student1 = em1.find(Student.class, 4L);
		String guide1Name = student1.getGuide().getName(); 
		
		em1.getTransaction().commit();
		em1.close(); 
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();

		Student student2 = em2.find(Student.class, 4L);
		String guide2Name = student2.getGuide().getName();
		
		em2.getTransaction().commit();
		em2.close(); 		
		
		//stats.getSecondLevelCacheStatistics(regionName) has been deprecated since Hibernate 5.3, so using stats.getDomainDataRegionStatistics(regionName) instead
		System.out.println("Guide: " + stats.getDomainDataRegionStatistics("entity.Guide"));	

	}
}














