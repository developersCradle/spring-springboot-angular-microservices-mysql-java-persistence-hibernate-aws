package client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import entity.Guide;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Task1Client {
	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			
			//Preventing N+1 using "left join fetch" - loading all the students with their associated Guide objects with the Student objects selectively (whenever you need to load them eagerly)
			/*
			Query query = em.createQuery("select student from Student student left join fetch student.guide");
			List<Student> students = query.getResultList();	

			for (Student student : students) {
				//students who do not have a guide will not be loaded
				if(student.getGuide() != null) {				
					System.out.println(student.getName() + ": " + student.getEnrollmentId() + ": " + student.getGuide().getName());
				}
			}  
			*/
			
			//Preventing N+1 using EntityGraph ("Student.guide") - loading all the students with their associated Guide objects with the Student objects selectively (whenever you need to load them eagerly)			
			Query query = em.createQuery("select student from Student student")
										.setHint("jakarta.persistence.loadgraph", em.getEntityGraph("Student.guide"));
			List<Student> students = query.getResultList();	

			for (Student student : students) {
				//students who do not have a guide wilul not be loaded
				if(student.getGuide() != null) {				
					System.out.println(student.getName() + ": " + student.getEnrollmentId() + ": " + student.getGuide().getName());
				}
			}  
			
			
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