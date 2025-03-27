package client;

import org.hibernate.Session;

import util.HibernateUtil;
import entity.Parent;
import entity.ParentPrimaryKey;

public class CompositePrimaryKeyClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//persisting		
		ParentPrimaryKey parentPrimaryKey = new ParentPrimaryKey("Gavin", "King");
		Parent parent = new Parent(parentPrimaryKey);
		session.persist(parent);
		
		//retrieving	
		/*
		ParentPrimaryKey parentPrimaryKey = new ParentPrimaryKey("Gavin", "King");
		Parent parent = (Parent) session.get(Parent.class, parentPrimaryKey);	
		*/		
		
		session.getTransaction().commit();
		session.close();
		
	}
}
