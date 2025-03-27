package client;

import java.util.Set;

import entity.Guide;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Task1Client {	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");

		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();		
		
		Guide guide = em1.find(Guide.class, 2L);		
		Set<Student> students = guide.getStudents();	
		
		//Commenting out the following students.size() call won't have any impact on the rest of the code
		//int numOfStudents = students.size();
		
		//Just like the students.size() method call, the "students" collection proxy will get initialized through the following for loop as well
		Student student = null;
		for(Student nextStudent: students) {
			if(nextStudent.getId() == 2L) {
				student = nextStudent;
			}
		}
		
		em1.getTransaction().commit();
		em1.close();	

		guide.setSalary(2500);
		student.setName("Amy Jade Gill");
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		
		Guide mergedGuide = em2.merge(guide);
		
		em2.getTransaction().commit();
		em2.close();		

	}
}