package client;

import java.util.List;

import entity.Animal;
import entity.Cat;
import entity.Dog;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class InheritanceAndPolymorphicQueriesClient {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
        		try {
        			txn.begin();
        	
        			//Persisting a Cat and a Dog object  
        			
        			Cat cat = new Cat(); 
        			cat.setName("Lucy");
        	
        			Dog dog = new Dog();
        			dog.setName("Oliver");
        	
        			em.persist(cat);
        			em.persist(dog);         			      			
        	
        			//Polymorphic Query
        			/*
        			Query query = em.createQuery("select animal from Animal animal");
        			List<Animal> animals = query.getResultList();
        			for (Animal animal : animals) {
        				System.out.println(animal);
        			}    
        			*/
        	
        			//Querying Derived Class (Dog)
        			/*
        			List<Dog> dogs =em.createQuery("select dog from Dog dog").getResultList();
        			for (Dog dog : dogs) {
						System.out.println(dog);
					}
					*/
   
	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(em != null) { em.close(); }
        		}
        
	}
}