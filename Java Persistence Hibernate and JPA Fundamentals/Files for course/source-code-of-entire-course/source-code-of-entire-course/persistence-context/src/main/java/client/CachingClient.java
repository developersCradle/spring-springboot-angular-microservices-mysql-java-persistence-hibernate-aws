package client;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CachingClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student1 = em.find(Student.class, 1L);
		Student student2 = em.find(Student.class, 1L);
		Student student3 = em.find(Student.class, 1L);
		student3.setName("Kevin New2"); 
		String student1Name = student1.getName(); //"Kevin New2"
		em.refresh(student3);
		
		em.getTransaction().commit();
		em.close(); 
	}
}
