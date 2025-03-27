package client;

import java.util.HashSet;
import java.util.Set;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsingIdForEqualsAndHashCodeClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student = new Student("2021EE10444", "Rob Winter");
		System.out.println(student.hashCode());
		
		Set<Student> students = new HashSet<Student>();
		students.add(student);
		
		em.persist(student);
		System.out.println(student.hashCode());
		System.out.println(students.iterator().next().hashCode());
		System.out.println(students.contains(student));
		 
		em.getTransaction().commit();
		em.close(); 
	}
}
