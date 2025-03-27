package client;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class FlushingAtQueryExecutionWithFlushModeTypeCommitClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.find(Student.class, 2L);
		student.setName("Sherry Morgan");
		
		em.setFlushMode(FlushModeType.COMMIT);
		Query query = em.createQuery("select s.name from Student s where s.id = :id").setParameter("id", 2L);
		String name = (String) query.getSingleResult();
	
		em.getTransaction().commit();
		em.close(); 
	}
}