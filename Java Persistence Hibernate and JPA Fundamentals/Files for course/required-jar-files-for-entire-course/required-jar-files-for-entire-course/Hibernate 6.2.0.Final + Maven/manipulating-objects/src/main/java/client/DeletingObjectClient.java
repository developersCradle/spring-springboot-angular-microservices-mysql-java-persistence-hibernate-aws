package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Message;

public class DeletingObjectClient {
	public static void main(String[] args) {  
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction txn = session.getTransaction();
                try {
                        txn.begin();

                        //Deleting Message[id=2L]
                        Message message = (Message) session.get(Message.class, 2L);
                        session.delete(message);               
                        
                        txn.commit();                         
                }	catch(Exception e) {
                        if(txn != null) { txn.rollback(); }
                        e.printStackTrace();
                }	finally {
                        if(session != null) { 
                                session.close();  }
                }
	
	}
}

