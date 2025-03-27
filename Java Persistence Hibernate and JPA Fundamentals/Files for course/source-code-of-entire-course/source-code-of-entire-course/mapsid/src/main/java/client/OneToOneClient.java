package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Customer;
import entity.Passport;

public class OneToOneClient {
	public static void main(String[] args) {
		
	            Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        	
        			Passport passport = new Passport("925076473");
        			Customer customer = new Customer("Nicole Scott", passport);

        			session.persist(customer);
  
					txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}












