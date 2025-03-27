package client;

import java.util.List;

import dto.EmployeeDto;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.Persistence;
import jakarta.persistence.StoredProcedureQuery;

public class FindNameAndSalaryeByDepartmentStoredProcedureClient {
	@SuppressWarnings("unchecked")
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
		
		//using named-stored-procedure (FindNameAndSalaryByDepartmentProcedure)
		StoredProcedureQuery q = em2.createNamedStoredProcedureQuery("FindNameAndSalaryByDepartmentProcedure");
		q.setParameter("dept", "Engineering");
		q.execute();
		List<EmployeeDto> empDtoList = q.getResultList();
		for (EmployeeDto empDto : empDtoList) {
			System.out.println("Name: " + empDto.getName() + ", Salary: " + empDto.getSalary());
		}
		
		//using stored-procedure (find_name_and_salary_by_department)
		/*
		StoredProcedureQuery q = em2.createStoredProcedureQuery("find_name_and_salary_by_department", "EmployeeDtoMapping");
		q.registerStoredProcedureParameter("p_dept", String.class, ParameterMode.IN);
		q.setParameter("p_dept", "Engineering");
		q.execute();
		List<EmployeeDto> empDtoList = q.getResultList();
		for (EmployeeDto empDto : empDtoList) {
			System.out.println("Name: " + empDto.getName() + ", Salary: " + empDto.getSalary());
		}
		*/
		em2.getTransaction().commit();
		em2.close();
	}

}
