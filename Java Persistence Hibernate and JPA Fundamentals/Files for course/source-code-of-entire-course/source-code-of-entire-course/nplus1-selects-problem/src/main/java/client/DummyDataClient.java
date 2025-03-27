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
		
		/*		
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
		*/		
    	
		Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 1000);
		Guide guide2 = new Guide("2000IM10901", "Ian Lamb", 2000);	
		Guide guide3 = new Guide("2000DO10777", "David Crow", 3000);	
		Guide guide4 = new Guide("2000BU10821", "Brett Boydstun", 4000);	
		Guide guide5 = new Guide("2000EL10793", "Erich Esterly", 5000);	
		Guide guide6 = new Guide("2000SO10654", "Sherill Stinson", 6000);	
		Guide guide7 = new Guide("2000DO10777", "Leo Level", 7000);	
		
		Student student1 = new Student("2014AL50456", "Amy Gill");
		Student student2 = new Student("2014JT50123", "John Smith");
		Student student3 = new Student("2014BE50789", "Bruce Lee");
		Student student4 = new Student("2014RG50454", "Rahul Singh");
		Student student5 = new Student("2014BC50168", "Bob Church");
		Student student6 = new Student("2014ST50743", "Sadie Evatt");
		Student student7 = new Student("2014JK50385", "Johnnie Jelks");
		Student student8 = new Student("2014JA50977", "Joslyn Jandreau");
		Student student9 = new Student("2014SE50918", "Sidney Strauser");
		Student student10 = new Student("2014TU50471", "Tianna Armentrout");
		Student student11 = new Student("2014AE50802", "Angelica Zapien");
		
		guide2.addStudent(student1);
		guide2.addStudent(student2);
		guide2.addStudent(student10);   		
		guide2.addStudent(student11);   		
		guide3.addStudent(student4);   
		guide4.addStudent(student5);   
		guide5.addStudent(student6);   
		guide6.addStudent(student7);   
		guide7.addStudent(student8); 
		guide7.addStudent(student9);   

		em.persist(guide1);
		em.persist(guide2);
		em.persist(student3);	
		em.persist(guide3);
		em.persist(guide4);
		em.persist(guide5);
		em.persist(guide6);
		em.persist(guide7);
		
		em.getTransaction().commit();
		em.close();	
		
		//[END: Adding data to student and guide tables]
	}
	
}
