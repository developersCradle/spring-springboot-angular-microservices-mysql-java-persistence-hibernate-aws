package client;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PreInsertIdGenerationClient {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student = new Student("2003CH50897", "Kevin Smith");
		
		em.persist(student);
		 
		em.getTransaction().commit();
		em.close(); 		
		emf.close();
		
	}
}
