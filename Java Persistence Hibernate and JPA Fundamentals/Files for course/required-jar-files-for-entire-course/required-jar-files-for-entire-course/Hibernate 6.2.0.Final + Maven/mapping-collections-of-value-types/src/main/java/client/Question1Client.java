package client;

import org.hibernate.Session;

import util.HibernateUtil;
import entity.Address;
import entity.Friend;
import entity.Item;

public class Question1Client {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//Persisting foo, b and c items		
		
		Item foo = new Item("Foo");
		foo.getImages().add("foo.jpg");
		foo.getImages().add("bar.jpg");
		foo.getImages().add("baz.png");
		
		Item b = new Item("B");
		b.getImages().add("b.jpg");
		
		Item c = new Item("C");
		c.getImages().add("c.png");

		session.persist(foo);		
		session.persist(b);	
		session.persist(c);	
		
		
		//Retrieving
		/*
		Item item = (Item) session.get(Item.class, 1L);
		System.out.println(item);		
		*/
		
		session.getTransaction().commit();
		session.close();
		
	}
}
