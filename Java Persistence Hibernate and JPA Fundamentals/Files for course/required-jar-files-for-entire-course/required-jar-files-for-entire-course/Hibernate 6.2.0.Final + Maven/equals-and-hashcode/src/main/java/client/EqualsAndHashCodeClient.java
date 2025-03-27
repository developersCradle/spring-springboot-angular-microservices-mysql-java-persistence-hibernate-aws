package client;

import java.util.Set;

import entity.Guide;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EqualsAndHashCodeClient {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		//Student[id=2L] and Guide[id=2L] are  being managed by different EntityManager (em1 and em2)
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();   
		
		Student student = em1.find(Student.class, 2L);

		em1.getTransaction().commit();
		em1.close();
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();   
		
		Guide guide = em2.find(Guide.class, 2L);
		Set<Student> students = guide.getStudents();
		
		System.out.println(students.contains(student));
		
		em2.getTransaction().commit();
		em2.close();
		

		//Student[id=2L] and Guide[id=2L], both are  being managed by the same EntityManager (em)
		/*
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();   
		
		Student student = em.find(Student.class, 2L);
		
		Guide guide = em.find(Guide.class, 2L);
		Set<Student> students = guide.getStudents();		
		
		System.out.println(students.contains(student));

		em.getTransaction().commit();
		em.close();
		*/
        
	}
}


































