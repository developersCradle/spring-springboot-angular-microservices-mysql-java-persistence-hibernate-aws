package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id    
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    
    public Book() {}    
	public Book(String title, String isbn) {
		this.title = title;
		this.isbn = isbn;
	}
	public Book(Long id, String title, String isbn) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
	}

	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + "]";
	}  
	
}
