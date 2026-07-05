package client;

import java.util.List;

import entity.Guide;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class NPlus1SelectsProblemClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em0 = emf.createEntityManager();
		em0.getTransaction().begin();
		
		Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 1000);
		Guide guide2 = new Guide("2000IM10901", "Ian Lamb", 2000);
		Guide guide3 = new Guide("2000DO10777", "David Crow", 3000);
		
		Student student1 = new Student("2014AL50456", "Amy Gill");
		Student student2 = new Student("2014JT50123", "John Smith");
		Student student3 = new Student("2014BE50789", "Bruce Lee");
		Student student4 = new Student("2014RG50347", "Rahul Singh");
		
		guide2.addStudent(student1);
		guide2.addStudent(student2);
		guide3.addStudent(student4);
		
		em0.persist(guide1);
		em0.persist(guide2);
		em0.persist(student3);
		em0.persist(guide3);			
		
		em0.getTransaction().commit();	
		em0.close();		
		
		//===============
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();


		//Adding data to guide and student table by adding a Guide and associating a Student with it
		/*
		Guide guide = new Guide("2000DO10777", "David Crow", 3000);		
		Student student = new Student("2014RG50347", "Rahul Singh");			
		guide.addStudent(student);
		em.persist(guide);
		*/

		//Loading all the student objects
		/*
		Query query = em.createQuery("select student from Student student");
		List<Student> students = query.getResultList();	

		for (Student student : students) {
			System.out.println(student.getName() + ": " + student.getEnrollmentId());
		}  
		*/

		//Loading all the students with their associated Guide objects with the Student objects selectively (whenever you need to load them eagerly)
		
		Query query = em.createQuery("select student from Student student left join fetch student.guide");
		List<Student> students = query.getResultList();	

		for (Student student : students) {
			//students who do not have a guide will not be loaded
			if(student.getGuide() != null) {				
				System.out.println(student.getName() + ": " + student.getEnrollmentId() + ": " + student.getGuide().getName());
			}
		}  		
		

		em.getTransaction().commit();	
		em.close();


	}
}