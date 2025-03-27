package client;

import org.hibernate.Session;

import entity.Book;
import entity.Chapter;
import entity.ChapterId;
import entity.Publisher;
import util.HibernateUtil;

public class BookStoreClient {
	public static void main(String[] args) {
			
        Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();

		//persisting object graph of Book
		
		Publisher publisher = new Publisher("OREI", "O'Reilly Media, Inc.");        			
		Book book = new Book("9781449334376", "Just Hibernate", publisher);			

		ChapterId chapter1Id = new ChapterId(book.getIsbn(), 1);
		Chapter chapter1 = new Chapter(chapter1Id, "Basics");
		book.addChapter(chapter1);
		
		ChapterId chapter2Id = new ChapterId(null, 2); //"null" won't make any difference as "isbn" in ChapterId will be ignored by Hibernate
		Chapter chapter2 = new Chapter(chapter2Id, "Fundamentals");
		book.addChapter(chapter2);

		session.persist(book);		 		
		
		
		//retrieving object graph of Book by its "id" (isbn)	
		/*
		Book book = (Book) session.get(Book.class, "9781449334376");
		System.out.println(book);		
		*/  
		session.getTransaction().commit();
		session.close();	
	}
}
