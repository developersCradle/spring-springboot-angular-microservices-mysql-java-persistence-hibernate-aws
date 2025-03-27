package client;

import java.util.List;

import entity.Guide;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

//generated Guide_ metamodel after enabling Annotation Processing
//import entity.Guide_;

//generated Student_ metamodel after enabling Annotation Processing
//import entity.Student_;

public class JoiningAssociationsClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();		

			//JOINING ASSOCIATIONS - inner join
			
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Student> criteria = builder.createQuery( Student.class );
			Root<Student> root = criteria.from(Student.class);
			
			// Student.guide is a @ManyToOne
			Join<Student, Guide> guide = root.join( "guide" );
			//Join<Student, Guide> guide = root.join( Student_.guide);
			criteria.select(root);
			
			TypedQuery<Student> query = em.createQuery(criteria);
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}
			
			//############################
			
			//JOINING ASSOCIATIONS - left outer join
			/*
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Student> criteria = builder.createQuery( Student.class );
			Root<Student> root = criteria.from(Student.class);
			
			// Student.guide is a @ManyToOne
			Join<Student, Guide> guide = root.join( "guide", JoinType.LEFT );
			//Join<Student, Guide> guide = root.join( Student_.guide, JoinType.LEFT );
			criteria.select(root);
			
			TypedQuery<Student> query = em.createQuery(criteria);
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}
			*/
			//############################
			
			//FETCHING ASSOCIATIONS - without fetch (only with join)
			/*
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Guide> criteria = builder.createQuery( Guide.class );
			Root<Guide> root = criteria.from(Guide.class);
			
			// Guide.students is a @OneToMany
			Join<Guide, Student> students = root.join( "students");
			//Join<Guide, Student> students = root.join( Guide_.students);
			criteria.select(root);
			
			TypedQuery<Guide> query = em.createQuery(criteria);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/
			//############################
			
			//FETCHING ASSOCIATIONS - with join fetch
			/*
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Guide> criteria = builder.createQuery( Guide.class );
			Root<Guide> root = criteria.from(Guide.class);
			
			// Guide.students is a @OneToMany
			Fetch<Guide, Student> students = root.fetch( "students");
			//Fetch<Guide, Student> students = root.fetch( Guide_.students);
			criteria.select(root);
			
			TypedQuery<Guide> query = em.createQuery(criteria);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/
			//############################
			
			//FETCHING ASSOCIATIONS - with left join fetch
			/*
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Guide> criteria = builder.createQuery( Guide.class );
			Root<Guide> root = criteria.from(Guide.class);
			
			// Guide.students is a @OneToMany
			Fetch<Guide, Student> students = root.fetch( "students", JoinType.LEFT);
			//Fetch<Guide, Student> students = root.fetch( Guide_.students, JoinType.LEFT);
			criteria.select(root);
			
			TypedQuery<Guide> query = em.createQuery(criteria);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}			
			*/
			//############################
			
			//FETCHING DISTINCT RESULTS
			/*
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Guide> criteria = builder.createQuery(Guide.class).distinct( true );
			Root<Guide> root = criteria.from(Guide.class);
			
			// Guide.students is a @OneToMany
			Fetch<Guide, Student> students = root.fetch( "students", JoinType.LEFT);
			//Fetch<Guide, Student> students = root.fetch( Guide_.students, JoinType.LEFT);
			criteria.select(root);
			
			TypedQuery<Guide> query = em.createQuery(criteria);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
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














