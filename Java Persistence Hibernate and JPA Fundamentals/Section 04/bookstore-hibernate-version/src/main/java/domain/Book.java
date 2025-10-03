package domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Book {
	
	@Id
	@Column(name="ISBN")
	private String isbn;
	
	
	@Column(name="BOOK_NAME")
	private String name;
	
	
//	If the many Books can one Publisher.
//	Or
//	There can be, Book can have many Publishers.
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "PUBLISHER_CODE")
	private Publisher publisher;
	
	
	public Book() {}
	public Book(String isbn, String name, Publisher publisher) {
		this.isbn = isbn;
		this.name = name;
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", publisher="
				+ publisher + " ]";
	}
}












































