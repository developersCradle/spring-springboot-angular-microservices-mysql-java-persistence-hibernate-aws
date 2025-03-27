package client;

import entity.Guide;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DummyDataClient {
	
	public static void main(String[] args) {
		
		//[BEGIN: Adding data to student and guide tables]
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			
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
		
		em.persist(guide1);
		em.persist(guide2);
		em.persist(student3);
		em.persist(guide3);		
		
		em.getTransaction().commit();
		em.close();	
		
		//[END: Adding data to student and guide tables]
	}
	
}
