package client;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CachingAndObjectIdentityClient {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			
			Guide guide1 = em.find(Guide.class, 2L);
			Guide guide2 = em.find(Guide.class, 2L);
			Guide guide3 = (Guide) em.createQuery("select guide from Guide guide where guide.id = :id").setParameter("id", 2L).getSingleResult();			

			txn.commit();			
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}
}