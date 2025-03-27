package client;

import java.util.List;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class NativeSQLQueryClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();						
			
			//NATIVE-SQL QUERY			
			Query query = em.createNativeQuery("select * from student", Student.class);
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}			
			
			/*
			Query query = em.createNativeQuery("select name, enrollment_id from student");
			List<Object[]> result = query.getResultList();
			for (Object[] tuple : result) {
				System.out.println("name: " + tuple[0] + ", enrollment_id: " + tuple[1]);
			}
			*/
			
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














