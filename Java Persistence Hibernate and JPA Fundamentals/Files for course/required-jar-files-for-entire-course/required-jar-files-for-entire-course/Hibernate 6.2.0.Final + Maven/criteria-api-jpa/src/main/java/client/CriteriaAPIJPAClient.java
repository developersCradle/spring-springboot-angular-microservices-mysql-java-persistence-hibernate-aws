package client;

import java.util.List;

import entity.Guide;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

//generated Guide_ metamodel after enabling Annotation Processing
//import entity.Guide_;

//generated Student_ metamodel after enabling Annotation Processing
//import entity.Student_;

public class CriteriaAPIJPAClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();			
			
			//QUERYING ENTITIES			
			
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Guide> criteria = builder.createQuery( Guide.class );
			Root<Guide> root = criteria.from( Guide.class );
			criteria.select(root);
			
			TypedQuery<Guide> query = em.createQuery(criteria);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}   
			
			//############################
			
			//SINGLE FIELD SELECTION - Querying just for the name field of the Guide entity
			/*
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<String> criteria = builder.createQuery( String.class );
			Root<Guide> root = criteria.from( Guide.class );
			Path<String> name = root.get("name");
			//Path<String> name = root.get(Guide_.name); //using Guide_ metamodel
			criteria.select(name);
			
			TypedQuery<String> query = em.createQuery(criteria);
			List<String> names = query.getResultList();
			for (String name_ : names) {
				System.out.println(name_);
			} 
			*/
				
			//############################
			
			//SINGLE FIELD SELECTION - Querying just for the name field of the Guide entity [using JPQL]
			/*
			TypedQuery<String> typedQuery = em.createQuery("select g.name from Guide g", String.class);
			List<String> names = typedQuery.getResultList();
			for (String name : names) {
				System.out.println(name);
			}
			*/
			
			//############################
			
			//REPORT QUERIES - using multiselect or builder.array
			/*
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Object[]> criteria = builder.createQuery( Object[].class );
			Root<Guide> root = criteria.from( Guide.class );

			Path<String> name = root.get( "name" );
			Path<Integer> salary = root.get( "salary" );
			//Path<String> name = root.get(Guide_.name);
			//Path<Integer> salary = root.get(Guide_.salary);

			//criteria.multiselect( name, salary );
			criteria.select( builder.array( name, salary ) );

			TypedQuery<Object[]> query = em.createQuery(criteria);
			List<Object[]> resultList = query.getResultList();
			for (Object[] objects : resultList) {
				System.out.println("Object[] {objects[0]: " + objects[0] + ", objects[1]: " + objects[1] + "}");				
			}
			*/
			//############################
			
			//FILTERING RESULTS		'
			/*
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Guide> criteria = builder.createQuery( Guide.class );
			Root<Guide> root = criteria.from( Guide.class );
			Path<Integer> salary = root.get("salary");
			//Path<Integer> salary = root.get(Guide_.salary);
			criteria.where( builder.equal(salary, "1000" ) );
			criteria.select(root);			

			TypedQuery<Guide> query = em.createQuery(criteria);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			} 
			*/
			//############################
			
			//DYNAMIC QUERIES	
			/*
			String name = "Ian Lamb"; //simulating dynamic query
			
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Guide> criteria = builder.createQuery( Guide.class );
			Root<Guide> root = criteria.from( Guide.class );
			criteria.where( builder.equal(root.get("name"), builder.parameter(String.class, "name") ) );
			//criteria.where( builder.equal(root.get(Guide_.name), builder.parameter(String.class, "name") ) );
			criteria.select(root);			

			TypedQuery<Guide> query = em.createQuery(criteria).setParameter("name", name);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			} 
			*/	
			//############################
			
			//WILDCARDS		
			/*
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Guide> criteria = builder.createQuery( Guide.class );
			Root<Guide> root = criteria.from( Guide.class );
			
			Path<String> staffId =  root.get("staffId");
			//Path<String> staffId =  root.get(Guide_.staffId);
			criteria.where( builder.like(staffId, "2000%")); 	

			criteria.select(root);			

			TypedQuery<Guide> query = em.createQuery(criteria);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/
			//############################
			
			//NATIVE-SQL QUERY
			/*
			Query query = em.createNativeQuery("select * from student", Student.class);
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}			
			*/
			
			/*
			Query query = em.createNativeQuery("select name, enrollment_id from student");
			List<Object[]> result = query.getResultList();
			for (Object[] tuple : result) {
				System.out.println("name: " + tuple[0] + ", enrollment_id: " + tuple[1]);
			}
			*/
			//############################	
		
			//NAMED QUERY - using orm.xml		
			/*
			TypedQuery<Guide> typedQuery = em.createNamedQuery("findByGuide", Guide.class)
																				 .setParameter("name", "Ian Lamb");
			List<Guide> guides = typedQuery.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/
			//############################
			
			//NAMED QUERY - using @NamedQuery annotation in Guide entity
			/*
			TypedQuery<Guide> typedQuery = em.createNamedQuery("Guide.findByName", Guide.class)
																				 .setParameter("name", "Ian Lamb");
			List<Guide> guides = typedQuery.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/
			//############################
			
			//AGGREGATE FUNCTION - count
			/*
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Long> criteria = builder.createQuery( Long.class );
			Root<Guide> root = criteria.from( Guide.class );
			criteria.select(builder.count(root));
			
			TypedQuery<Long> query = em.createQuery(criteria);
			Long numOfGuides = query.getSingleResult();
			System.out.println(numOfGuides);
			*/		
			//############################
			
			//AGGREGATE FUNCTION - max
			/*
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Integer> criteria = builder.createQuery( Integer.class );
			Root<Guide> root = criteria.from( Guide.class );
			Path<Integer> salary = root.get("salary");
			//Path<Integer> salary = root.get(Guide_.salary);
			criteria.select(builder.max(salary));
			
			TypedQuery<Integer> query = em.createQuery(criteria);
			Integer maxSalary = query.getSingleResult();
			System.out.println(maxSalary);
			*/
			//############################
			
			//JOINING ASSOCIATIONS - inner join
			/*
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
			*/
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














