package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Message;
import util.HibernateUtil;

public class HelloWorldClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction transaction = session.getTransaction();
        		
        		// We are going to make transaction.
        		try {
					transaction.begin();
					
					// Message object is managed by session.
					Message message = (Message) session.get(Message.class, 3L);
					message.setText(" This text is changed.");
//					System.out.println(message);
					
					
					
					transaction.commit();
					
				} catch (Exception e) {
					if (transaction != null) {
						transaction.rollback(); // Something happened in the query process. If transaction is not null, we are going to rollback.
					}
					e.printStackTrace();
				} finally {
					if (session != null)
					{		
						session.close();
					}
				}
	
	}
}

