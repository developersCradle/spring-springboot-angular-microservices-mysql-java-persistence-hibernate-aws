package client;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Question1Client {	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();		
		
		Guide guide1 = em.find(Guide.class, 2L);
		Guide guide2 = (Guide) em.createQuery("select guide from Guide guide where guide.id = :id").setParameter("id", 2L).getSingleResult();			
		Guide guide3 = (Guide) em.createQuery("select guide from Guide guide where guide.name = :name").setParameter("name", "Ian Lamb").getSingleResult();

	
		em.getTransaction().commit();
		em.close();	

	}
}
