package client;

import java.util.Set;

import entity.Guide;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OrderByClient {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Guide guide = em.find(Guide.class, 2L);
		Set<Student> students = guide.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}	
		
		em.getTransaction().commit();
		em.close();         
	}
}