package client;

import java.util.Set;

import entity.Guide;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MergingDetachedObjectsClient {	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");

		//=============================
		//Detached Objects
		//=============================
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();		
		
		Guide guide = em1.find(Guide.class, 2L);		
		Set<Student> students = guide.getStudents();		
		int numOfStudents = students.size();
		
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

		//=============================
		//Extended Persistence Context
		//=============================
		/*
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Guide guide = em.find(Guide.class, 2L);
		Set<Student> students = guide.getStudents();
		int numOfStudents = students.size();

		Student student = null;
		for(Student nextStudent: students) {
			if(nextStudent.getId() == 1L) {
				student = nextStudent;
			}
		}

		em.getTransaction().commit();

		guide.setSalary(2500);
		student.setName("Amy Jade Gill");

		em.getTransaction().begin();

		//merging not needed

		em.getTransaction().commit();

		em.close();
		*/	
	}
}