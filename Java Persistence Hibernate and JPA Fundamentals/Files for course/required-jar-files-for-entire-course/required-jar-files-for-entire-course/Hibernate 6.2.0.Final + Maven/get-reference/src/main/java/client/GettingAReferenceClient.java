package client;

import org.hibernate.Hibernate;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GettingAReferenceClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.getReference(Student.class, 3L);
		String studentName = student.getName(); //issues SELECT and initializes the proxy
		//Hibernate.initialize(student); //issues SELECT and initializes the proxy
		
		em.getTransaction().commit();
		em.close(); 
	}
}
