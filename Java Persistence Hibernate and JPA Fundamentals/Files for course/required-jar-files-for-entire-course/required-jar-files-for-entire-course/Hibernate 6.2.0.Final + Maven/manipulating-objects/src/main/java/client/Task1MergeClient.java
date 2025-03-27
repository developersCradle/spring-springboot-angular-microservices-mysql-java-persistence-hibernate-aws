package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Message;

public class Task1MergeClient {
	public static void main(String[] args) {  
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();

        Message message = (Message) session1.get(Message.class, 3L); 
        System.out.println(message);

		session1.getTransaction().commit();
		session1.close();
		
		message.setText("Updated " + message.getText());	
		
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		
		Message message2 = (Message) session2.get(Message.class, 3L);
        session2.merge(message);	

		session2.getTransaction().commit();
		session2.close();		
		
		System.out.println(message);
	}
}

