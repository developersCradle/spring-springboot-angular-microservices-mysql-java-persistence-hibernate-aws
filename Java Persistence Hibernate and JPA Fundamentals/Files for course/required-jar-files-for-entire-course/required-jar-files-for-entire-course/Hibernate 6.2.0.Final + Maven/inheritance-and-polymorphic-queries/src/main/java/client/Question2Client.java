package client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Question2Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();   
		
		/*
		Cat cat = new Cat(); 
		cat.setName("Lucy");
		cat.setPurringLevel(6);	//uncomment setPurringLevel() method in Cat class

		Dog dog = new Dog();
		dog.setName("Oliver");
		dog.setBarkingLevel(3);  //uncomment setBarkingLevel() method in Dog class

		em.persist(cat);
		em.persist(dog);
		*/

		em.getTransaction().commit();
		em.close();
	}
}


































