
package client;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Question1Client {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();

		Student student1 = em1.find(Student.class, 2L);

		em1.getTransaction().commit();
		em1.close();

		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();

		Student student2 = em2.find(Student.class, 2L);
		        
		System.out.println(student1.equals(student2));

		em2.getTransaction().commit();
		em2.close();

        
	}
}


































