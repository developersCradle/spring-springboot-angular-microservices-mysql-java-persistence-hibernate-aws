package client;

import org.hibernate.Session;

import entity.Employee;
import enums.EmployeeStatus;
import util.HibernateUtil;

public class Question1Client {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//persisting
		Employee employee1 = new Employee("Josh Stockham", "2014JA11001", EmployeeStatus.FULL_TIME);
		Employee employee2 = new Employee("Ammie Corrio", "2014AI21543", EmployeeStatus.PART_TIME);
		Employee employee3 = new Employee("Ernie Stenseth", "2014ET25100", EmployeeStatus.CONTRACT);

		session.persist(employee1);
		session.persist(employee2);
		session.persist(employee3);
		
		/*
		Employee employee = (Employee) session.get(Employee.class, 2L);
		System.out.println(employee);
		*/
		
		session.getTransaction().commit();
		session.close();
		
	}	

}
