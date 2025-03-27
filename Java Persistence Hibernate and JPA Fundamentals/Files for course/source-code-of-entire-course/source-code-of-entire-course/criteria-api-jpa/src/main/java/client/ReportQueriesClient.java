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
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;

//generated Guide_ metamodel after enabling Annotation Processing
//import entity.Guide_;

//generated Student_ metamodel after enabling Annotation Processing
//import entity.Student_;

public class ReportQueriesClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();			
			
			//REPORT QUERIES - using builder.array or multiselect
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














