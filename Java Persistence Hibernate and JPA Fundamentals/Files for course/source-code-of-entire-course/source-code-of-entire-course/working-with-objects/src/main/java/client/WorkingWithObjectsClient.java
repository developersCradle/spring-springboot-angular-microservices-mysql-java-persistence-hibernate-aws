package client;

import entity.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class WorkingWithObjectsClient {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		
		Message message = new Message("Hello"); //transient state        
		em.persist(message); //persistent state        
		
		txn.commit();	
		em.close(); 
		
		message.setText("Hi"); //modifying the detached state of message

		EntityManager em2 = emf.createEntityManager();
		EntityTransaction txn2 = em2.getTransaction();
		txn2.begin();
		
		//the returned mergedMessage is a persistent object
		//any changes to mergedMessage will be dirty checked when the txn2 will be committed and updated in the database
		Message mergedMessage = em2.merge(message);
		
		txn2.commit();
		em2.close(); 		
		
		
		//Detaching objects explicitly
		/*
		EntityManager em3 = emf.createEntityManager();
		EntityTransaction txn3 = em3.getTransaction();
		txn3.begin();

		Message msg = new Message("Howdy"); //transient state        
		em3.persist(msg); //persistent state    
		
		em3.detach(msg); //detaching the message object explicitly
		txn3.commit();
		em3.close();
		*/	
        
	}
}



