package entity;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Friend{

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
	private String email;

	@ElementCollection
	@CollectionTable(name = "friend_nickname", joinColumns=@JoinColumn(name = "friend_id"))
	@Column(name = "nickname")
	private Collection<String> nicknames = new ArrayList<String>();

	//collection of embeddable Address objects [with default address specific column names being overridden using @AttributeOverride]
	/*
	@AttributeOverrides( {
		@AttributeOverride(name="street", column=@Column(name="address_street")),
		@AttributeOverride(name="city", column=@Column(name="address_city")),
		@AttributeOverride(name="zipcode", column=@Column(name="address_zipcode"))
	} )
	private Collection<Address> addresses = new ArrayList<Address>();	
	public Collection<Address> getAddresses() {
		return addresses;
	}
	*/
	
	public Friend() {}
	public Friend(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public Collection<String> getNicknames() {
		return nicknames;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", email=" + email + ", nicknames=" + nicknames + "]";
	}
	
}
