package client;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Persistence;

public class UserXClient {	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();		
		
		//READ Lock
		List<Object[]> resultList = em.createQuery("select guide.name, guide.salary from Guide as guide")
															.setLockMode(LockModeType.PESSIMISTIC_READ)
															.getResultList();
		
		//WRITE Lock
		/*
		List<Object[]> resultList = em.createQuery("select guide.name, guide.salary from Guide as guide")
															.setLockMode(LockModeType.PESSIMISTIC_WRITE)
															.getResultList();
		*/
		
		for (Object[] objects : resultList) {
			System.out.println("Object[] {objects[0]: " + objects[0] + ", objects[1]: " + objects[1] + "}");			
		}		
		
		Long sumOfSalaries = (Long) em.createQuery("select sum(guide.salary) from Guide as guide").getSingleResult();
		System.out.println("[sumOfSalaries: " + sumOfSalaries + "]");
		
		//Updating all guides by raising their salaries 4 times with WRITE Lock
		/*
		em.createQuery("update Guide as guide set guide.salary = guide.salary * 4").executeUpdate();
		*/
	
		em.getTransaction().commit();
		em.close();	

	}
}
