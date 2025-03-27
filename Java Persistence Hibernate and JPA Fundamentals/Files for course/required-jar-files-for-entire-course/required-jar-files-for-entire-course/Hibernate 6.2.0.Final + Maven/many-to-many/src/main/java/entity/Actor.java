package entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Actor {
	
	//1. Before Hibernate 5.x, GenerationType.AUTO used GenerationType.IDENTITY as default strategy
	//2. After Hibernate 5.x, GenerationType.AUTO used GenerationType.SEQUENCE as default strategy
	//3. To follow the course with Hibernate 6.y, use GenerationType.IDENTITY strategy explicitly
	//4. Q&A on AUTO vs IDENTITY: https://www.udemy.com/course/hibernate-and-jpa-fundamentals/learn/lecture/26324154#questions/937412
	//5. In the lecture on "Pre-INSERT Identifier Generation", we talk more about AUTO, IDENTITY, SEQUENCE and TABLE strategies
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ID")	
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="actors")
	private Set<Movie> movies = new HashSet<Movie>();
	
	public Actor() {}	
	public Actor(String name) {
		this.name = name;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	//utility methods - synchronizing both sides (owner and inverse-end) of the relationship when you add and remove a Movie from an Actor
	public void addMovie(Movie movie) {
		this.movies.add(movie);
		movie.getActors().add(this);
	}	
	public void removeMovie(Movie movie) {
		this.movies.remove(movie);
		movie.getActors().remove(this);
	}
	
}