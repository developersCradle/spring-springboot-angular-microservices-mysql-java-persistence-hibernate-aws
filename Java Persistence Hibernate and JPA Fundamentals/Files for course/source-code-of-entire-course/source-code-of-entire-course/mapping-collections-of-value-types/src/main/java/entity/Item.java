package entity;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item{

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
	
	/*
	@ElementCollection
	@CollectionTable(name = "item_image", joinColumns=@JoinColumn(name = "item_id"))
	@Column(name = "filename")
	private Collection<String> images = new ArrayList<String>();
	*/
	
	@ElementCollection
	@Column(name = "filename")
	private Collection<String> images = new ArrayList<String>();
	
	public Item() {}
	public Item(String name) {
		this.name = name;
	}
	
	public Collection<String> getImages() {
		return images;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", images=" + images + "]";
	}
	
}
