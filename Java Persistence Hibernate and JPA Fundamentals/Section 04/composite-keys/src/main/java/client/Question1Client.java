package client;

import org.hibernate.Session;

import entity.A;
import entity.B;
import util.HibernateUtil;

public class Question1Client {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//persisting		
		B b = new B("Tommy Lee", 24, "An interesting fooval");
		session.persist(b);
		
		//retrieving	
		B returnedB = (B) session.get(B.class, new A("Tommy Lee", 24));
		System.out.println(returnedB);			
		
		session.getTransaction().commit();
		session.close();
		
	}
}
