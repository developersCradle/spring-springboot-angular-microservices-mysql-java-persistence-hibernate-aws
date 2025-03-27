package client;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class InsertDummyDataClient {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//persist the following 3 students to the 'mydb' database to work with the examples on flushing and Question1Client
		Student student1 = new Student("2003CH50897", "Kevin Smith");
		Student student2 = new Student("2008EE10999", "Sherry Morgan");
		Student student3 = new Student("1987CS10007", "Sara Shield");
		
		em.persist(student1);
		em.persist(student2);
		em.persist(student3);
		 
		em.getTransaction().commit();
		em.close(); 
		
	}
}
