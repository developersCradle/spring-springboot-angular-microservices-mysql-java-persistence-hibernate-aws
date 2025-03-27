package client;

import org.hibernate.Session;

import util.HibernateUtil;
import entity.Message;

public class LoggingClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		session.beginTransaction();
        
        		Message message = new Message( "JBOSS Logging Library with Log4j in Action, r3" );
        
        		session.save(message);    
        
        		session.getTransaction().commit();
        		session.close();
	
	}
}

