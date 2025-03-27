package client;

import java.util.List;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class QueryLanguageClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			//QUERYING ENTITIES
			
			Query query = em.createQuery("select guide from Guide guide");
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}   
			  	
			
			/*
			Query query = em.createQuery("select guide.name from Guide guide");
			List<String> names = query.getResultList();
			for (String name : names) {
				System.out.println(name);
			}
			*/	
			//############################

			//REPORT QUERIES
			/*
			Query query = em.createQuery("select guide.name, guide.salary from Guide guide");
			List<Object[]> resultList = query.getResultList();
			for (Object[] objects : resultList) {
				System.out.println("Object[] {objects[0]: " + objects[0] + ", objects[1]: " + objects[1] + "}");				
			}
			*/	
			//############################	
	
			//DYNAMIC QUERIES
			/*
			String name = "Ian Lamb"; //simulating dynamic query
			Query query = em.createQuery("select guide from Guide guide where guide.name = '" + name + "'");
			Guide guide = (Guide) query.getSingleResult();
			System.out.println(guide);			
			*/
	
			/*
			Query query = em.createQuery("select guide from Guide guide where guide.name = :name");
			query.setParameter("name", "Ian Lamb");
			Guide guide = (Guide) query.getSingleResult();
			System.out.println(guide);      
			*/
			//############################	
	
			//CHAINING METHOD CALLS
			/*
			Guide guide = (Guide) em.createQuery("select guide from Guide guide where guide.name = :name")
											        .setParameter("name", "Ian Lamb")
											        .getSingleResult();
			System.out.println(guide);
			*/
			
			//############################	
	
			//WILDCARDS
			/*
			Query query = em.createQuery("select guide from Guide guide where guide.name like 'm%'");
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/	
			//############################	

			//NATIVE SQL QUERIES
			/*
			Query query = em.createNativeQuery("select * from Guide", Guide.class);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/
			//############################	

			//NAMED QUERIES
			/*
			List<Guide> guides = em.createNamedQuery("findByGuide")
					       						.setParameter("name", "Mike Lawson")
					       						.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/

			/*
			int numOfGuides = em.createQuery("select guide from Guide guide").getResultList().size();
			System.out.println("[numOfGuides: " + numOfGuides + "]");
			*/	
			//############################	

			//AGGREGATE FUNCTIONS
			/*
			Query query = em.createQuery("select count(guide) from Guide guide");
			Long numOfGuides = (Long) query.getSingleResult();
			System.out.println("[numOfGuides: " + numOfGuides + "]");
			*/

			/*
			Query query = em.createQuery("select max(guide.salary) from Guide guide");
			Integer maximumSalary = (Integer) query.getSingleResult();
			System.out.println("[maximumSalary: " + maximumSalary + "]");        	
			*/
	
			/*
			Query query = em.createQuery("select guide from Guide guide where guide.salary = 1000");
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}     	
			*/	
			//############################	
	
			//PERSISTING A NEW STUDENT
			/*
			Student student = new Student("2014BE50789", "Bruce Lee");
			em.persist(student);
			*/
			//############################	
	
			//JOINING ASSOCIATIONS
			/*
			Query query = em.createQuery("select student from Student student join student.guide guide");
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}
			*/
	
			/*
			Query query = em.createQuery("select student from Student student left join student.guide guide");
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}
			*/
	
			/*
			Query query = em.createQuery("select student from Student student right join student.guide guide");
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}
			*/
			//############################

	
			//FETCHING ASSOCIATIONS
			/*
			Query query = em.createQuery("select guide from Guide guide join guide.students student");
			List<Guide> guides = query.getResultList();
			*/
	
			/*
			Query query = em.createQuery("select guide from Guide guide join fetch guide.students student");
			List<Guide> guides = query.getResultList();
			*/
			//############################

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














