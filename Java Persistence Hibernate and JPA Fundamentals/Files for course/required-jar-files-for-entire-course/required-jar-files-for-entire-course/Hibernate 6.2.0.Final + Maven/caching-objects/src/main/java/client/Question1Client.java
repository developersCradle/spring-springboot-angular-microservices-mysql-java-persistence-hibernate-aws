package client;

import entity.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Question1Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Message m = em.find(Message.class, 1L); //1
		m = em.merge(m); //2
		em.detach(m); //3
		em.remove(m); //4
		m = em.merge(m); //5
		System.out.println(em.contains(m)); //6		
	
		em.getTransaction().commit(); //7
		em.close();         
	}
}



