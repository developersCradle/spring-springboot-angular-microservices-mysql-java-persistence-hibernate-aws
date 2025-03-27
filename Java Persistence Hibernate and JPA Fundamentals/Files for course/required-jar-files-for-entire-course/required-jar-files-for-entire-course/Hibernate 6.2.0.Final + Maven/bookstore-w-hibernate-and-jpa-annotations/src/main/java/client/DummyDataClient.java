package client;

import org.hibernate.Session;

import entity.Book;
import entity.Chapter;
import entity.ChapterId;
import entity.Publisher;
import util.HibernateUtil;

public class DummyDataClient {
	public static void main(String[] args) {
			
        Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();

		//persisting object graph
		
		Publisher publisher = new Publisher("MANN", "Manning Publications Co.");        			
		Book book = new Book("9781617290459", "Java Persistence with Hibernate, Second Edition", publisher);			

		ChapterId chapter1Id = new ChapterId(book.getIsbn(), 1);
		Chapter chapter1 = new Chapter(chapter1Id, "Introducing JPA and Hibernate");
		book.addChapter(chapter1);
		
		ChapterId chapter2Id = new ChapterId(null, 2); //"null" won't make any difference as "isbn" in ChapterId will be ignored by Hibernate
		Chapter chapter2 = new Chapter(chapter2Id, "Domain Models and Metadata");
		book.addChapter(chapter2);

		System.out.println(book);
		session.persist(book);		 		
		
		//retrieving object graph
		/*
		Book book = (Book) session.get(Book.class, "9781617290459");
		System.out.println(book);		
		*/ 
		session.getTransaction().commit();
		session.close();
	}
}
