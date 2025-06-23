package client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Book;
import entity.Author;
import util.HibernateUtil;

public class MappingJsonClient {	
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		//persisting an Author
		Session session = sf.openSession();
		session.getTransaction().begin();
		
		Book book1 = new Book("Effective Java, 3rd Edition", "9356060665", 2022);
		Author author1 = new Author("Joshua Bloch", book1);

		session.persist(author1);		
			
		session.getTransaction().commit();
		session.close();		
		
		//finding an Author
		Session session2 = sf.openSession();
		session2.getTransaction().begin();
		
		Author author = session2.find(Author.class, 1L);
		System.out.println(author);
			
		session2.getTransaction().commit();
		session2.close();

	}
	
}
