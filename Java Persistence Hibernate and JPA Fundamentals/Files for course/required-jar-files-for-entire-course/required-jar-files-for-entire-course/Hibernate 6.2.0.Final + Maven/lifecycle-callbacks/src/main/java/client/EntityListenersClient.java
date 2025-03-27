package client;

import entity.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityListenersClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Message msg = new Message("Hello @EntityListeners");
		em.persist(msg);
		
		em.getTransaction().commit();
		em.close();
	}
}