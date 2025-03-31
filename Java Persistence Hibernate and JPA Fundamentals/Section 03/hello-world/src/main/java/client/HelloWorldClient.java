package client;

import org.hibernate.Session;

import entity.Message;
import util.HibernateUtil;

public class HelloWorldClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		session.beginTransaction();
        
        		Message message = new Message( "Hello World with Hibernate and JPA Annotations" );
        
//        		session.save(message); // Hibernate 5 uses .save
        		session.persist(message); // Hibernate 6 uses .persist
        
        		session.getTransaction().commit();
        		session.close();
	
	}
}

