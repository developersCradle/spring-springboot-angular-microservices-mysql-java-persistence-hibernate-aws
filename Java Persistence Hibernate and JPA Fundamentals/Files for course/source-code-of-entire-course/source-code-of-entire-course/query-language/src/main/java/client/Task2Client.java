package client;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Task2Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();   
		
		Query query = em.createQuery("select g.name, g.staffId from Guide g where size(g.students) = 0");
		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {
			System.out.println("Object[] {objects[0]: " + objects[0] + ", objects[1]: " + objects[1] + "}");				
		}

		em.getTransaction().commit();
		em.close();
	}
}


































