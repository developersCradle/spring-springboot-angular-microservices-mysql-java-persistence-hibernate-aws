package client;

import org.hibernate.Session;

import util.HibernateUtil;
import entity.Address;
import entity.Friend;

public class MappingCollectionsOfValueTypesClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//persisting		
		Friend friend = new Friend("Mark Anderson", "markanderson@pluswhere.com");
		
		friend.getNicknames().add("Marky");
		friend.getNicknames().add("Marco");
		friend.getNicknames().add("Markster");

		session.persist(friend);		
		
		//collection of embeddable Address object 
		/*
		Friend friend = new Friend("Mark Anderson", "markanderson@pluswhere.com");
		
		friend.getAddresses().add(new Address("street1", "city1", "zipcode1"));
		friend.getAddresses().add(new Address("street2", "city2", "zipcode2"));
		friend.getAddresses().add(new Address("street3", "city3", "zipcode3"));

		session.persist(friend);
		*/
		
		//retrieving		
		/*Friend friend = (Friend) session.get(Friend.class, 1L);
		System.out.println(friend);		*/
		
		session.getTransaction().commit();
		session.close();
		
	}
}
