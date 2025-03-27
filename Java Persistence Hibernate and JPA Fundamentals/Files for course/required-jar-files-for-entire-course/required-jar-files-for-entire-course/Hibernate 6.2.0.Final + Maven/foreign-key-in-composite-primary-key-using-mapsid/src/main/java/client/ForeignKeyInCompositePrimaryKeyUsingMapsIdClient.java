package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Department;
import entity.User;
import entity.UserId;
import util.HibernateUtil;

public class ForeignKeyInCompositePrimaryKeyUsingMapsIdClient {
	public static void main(String[] args) {
		
	            Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        	
        			//persisting User
        			
                    Department department = new Department("Psychology");
                    session.persist(department);
                    
                    UserId userId = new UserId("johndoe", department.getId()); //with @MapsId(“departmentId”), even if you pass "null” at the place of "department.getId()", it won’t matter!

                    User user = new User(userId, "johndoe@somewhere.com");
                    user.setDepartment(department); // Required!
                    session.persist(user);
                    
                    
        			//retrieving User        	
        			/*
                    UserId userId = new UserId("johndoe", 1L);
                    User user = (User) session.get(User.class, userId);
                    System.out.println(user);
                    */
  
					txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}












