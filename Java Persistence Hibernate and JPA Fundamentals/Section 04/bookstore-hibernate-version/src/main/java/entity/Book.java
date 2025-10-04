package entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book{

	@Id
	@Column(name = "ISBN", unique = true, nullable = false, length = 50)
	private String isbn;
	
	@Column(name = "BOOK_NAME", nullable = false, length = 100)
	private String name;
		
	@ManyToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name = "PUBLISHER_CODE")
	private Publisher publisher;
	
	@OneToMany(mappedBy = "book", cascade= {CascadeType.PERSIST})
	private Set<Chapter> chapters = new HashSet<Chapter>();

	public Book() {}
	public Book(String isbn, String name) {
		this.isbn = isbn;
		this.name = name;
	}
	public Book(String isbn, String name, Publisher publisher) {
		this.isbn = isbn;
		this.name = name;
		this.publisher = publisher;
	}
	public void addChapter(Chapter chapter) {
		this.chapters.add(chapter);
		chapter.setBook(this);
	}
	public void removeChapter(Chapter chapter) {
		this.chapters.remove(chapter);
		chapter.setBook(null);
	}
	public String getIsbn() {
		return isbn;
	}	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", publisher=" + publisher + ", chapters=" + chapters + "]";
	}
}
