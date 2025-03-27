package client;

import java.util.List;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Task3Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();   
		
		Query query = em.createQuery(" select g from Guide g join g.students s where s.name like 'A%' ");
		List<Guide> resultList = query.getResultList();
		for (Guide guide : resultList) {
			System.out.println(guide);
		}

		em.getTransaction().commit();
		em.close();
	}
}


































