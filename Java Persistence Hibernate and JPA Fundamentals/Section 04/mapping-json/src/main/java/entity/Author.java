package entity;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import domain.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;    
    
    public Author() {}
    public Author(String name, Book book) {
		this.name = name;
		this.book = book;
	}

	@JdbcTypeCode(SqlTypes.JSON)
    private Book book;

    @Override
    public String toString() {
        return "Author{ " + "id=" + id + ", name=" + name + ", book=" + book + " }";
    }
    
}
