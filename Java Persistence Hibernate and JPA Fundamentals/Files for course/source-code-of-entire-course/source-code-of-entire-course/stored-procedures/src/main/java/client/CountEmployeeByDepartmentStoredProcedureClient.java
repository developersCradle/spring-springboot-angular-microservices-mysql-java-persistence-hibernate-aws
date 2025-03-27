package client;

import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.Persistence;
import jakarta.persistence.StoredProcedureQuery;

public class CountEmployeeByDepartmentStoredProcedureClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();		
		
		Employee emp1 = new Employee("Mark Young", 5000, "Engineering");
		Employee emp2 = new Employee("Olivia Goy", 4500, "Accounting");
		Employee emp3 = new Employee("Joana Tom", 5500, "QA");
		Employee emp4 = new Employee("Alicia Nimar", 5000, "Engineering");
		Employee emp5 = new Employee("Katy Loin", 4500, "Engineering");
		Employee emp6 = new Employee("Rahul Singh", 4500, "Engineering");
		
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.persist(emp4);
		em.persist(emp5);
		em.persist(emp6);
		
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		
		//using named-stored-procedure (CountByDepartmentProcedure)
		StoredProcedureQuery q = em2.createNamedStoredProcedureQuery("CountByDepartmentProcedure");
		q.setParameter("dept", "Engineering");
		q.execute();
		Integer count = (Integer) q.getOutputParameterValue("count");
		System.out.println("count: " + count);
	
		
		//using stored-procedure (count_employee_by_department)
		/*
		StoredProcedureQuery q = em2.createStoredProcedureQuery("count_employee_by_department");
		q.registerStoredProcedureParameter("p_dept", String.class, ParameterMode.IN);
		q.registerStoredProcedureParameter("p_count", Integer.class, ParameterMode.OUT);
		q.setParameter("p_dept", "Engineering");
		q.execute();
		Integer count = (Integer) q.getOutputParameterValue("p_count");
		System.out.println("count: " + count);
		*/
		em2.getTransaction().commit();
		em2.close();		

	}

}
