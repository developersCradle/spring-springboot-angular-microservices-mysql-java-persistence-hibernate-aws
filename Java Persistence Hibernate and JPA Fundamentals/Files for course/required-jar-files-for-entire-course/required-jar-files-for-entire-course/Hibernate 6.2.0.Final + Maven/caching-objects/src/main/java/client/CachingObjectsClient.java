package client;

import entity.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CachingObjectsClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");

		//First-level Caching		
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Message message1 = em.find(Message.class, 7L);
		Message message2 = em.find(Message.class, 7L);

		em.getTransaction().commit();
		em.close();		


		// Is First-level Caching still going work?
		/*
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();

		Message message1 = em1.find(Message.class, 7L);

		em1.getTransaction().commit();
		em1.close();

		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();

		Message message2 = em2.find(Message.class, 7L);

		em2.getTransaction().commit();
		em2.close();
		*/

	}
}