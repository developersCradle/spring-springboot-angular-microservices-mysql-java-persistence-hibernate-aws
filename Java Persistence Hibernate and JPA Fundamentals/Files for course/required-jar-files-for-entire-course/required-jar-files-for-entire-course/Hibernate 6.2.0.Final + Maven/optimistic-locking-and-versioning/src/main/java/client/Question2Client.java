package client;

import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Question2Client {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");	
		
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		 
		User user1 = new User("john",		2,		1,		true);
		User user2 = new User("jane",		27,	2, 		true);
		User user3 = new User("nicole",	9,		1, 		false);
		User user4 = new User("ravi", 		19,	1, 		false);
		User user5 = new User("alissa", 	44, 	2, 		true);
		User user6 = new User("jacob", 	159, 	3, 		false);
		User user7 = new User("lucy", 		217,	4, 		true);
		
		em1.persist(user1);
		em1.persist(user2);
		em1.persist(user3);
		em1.persist(user4);
		em1.persist(user5);
		em1.persist(user6);
		em1.persist(user7);
		
		em1.getTransaction().commit();
		em1.close(); 
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();

		int updatedUsers = em2.createQuery("update versioned User u set u.level = :level where u.numOfPosts >= :nop and u.isActive = :isActive").setParameter("level", 5).setParameter("nop", 100).setParameter("isActive", true).executeUpdate();
		System.out.println(updatedUsers);
		
		em2.getTransaction().commit();		
		em2.close(); 
		
	}
}