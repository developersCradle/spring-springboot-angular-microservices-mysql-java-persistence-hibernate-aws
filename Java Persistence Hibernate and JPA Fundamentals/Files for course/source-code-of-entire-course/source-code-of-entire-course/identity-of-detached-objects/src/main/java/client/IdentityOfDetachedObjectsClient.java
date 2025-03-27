package client;

import java.util.HashSet;
import java.util.Set;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class IdentityOfDetachedObjectsClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student1 = em.find(Student.class, 2L);
		Student student2 = em.find(Student.class, 2L);
		
		System.out.println(student1 == student2);
		System.out.println(student1.equals( student2 ));
		System.out.println(student1.getId().equals( student2.getId() ));
	
		em.getTransaction().commit();		
		em.close(); 
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		
		Student student3 = em2.find(Student.class, 2L);
		
		System.out.println(student1 == student3);
		System.out.println(student1.equals( student3 ));
		System.out.println(student1.getId().equals( student3.getId() ));
	
		em2.getTransaction().commit();		
		em2.close(); 
		
		Set<Student> students = new HashSet<Student>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		System.out.println(students.size());
	}
}