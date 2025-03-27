package client;

import java.time.LocalDate;

import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TransientClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");		
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		
		Person person = new Person("Harry Bates", LocalDate.of(1983, 8, 8));
		em1.persist(person);
		
		em1.getTransaction().commit();
		em1.close();
	}
}