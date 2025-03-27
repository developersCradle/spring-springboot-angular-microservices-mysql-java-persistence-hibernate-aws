package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;

@Entity
public class Person {
	
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
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Transient
	private Integer age;	
	
	@Column(name="last_update")
	private LocalDateTime lastUpdate;	
	
	public Person() {}	
	public Person(String name, LocalDate dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	@PostLoad
	public void calculateAge() {
		this.age = Period.between(this.dateOfBirth, LocalDate.now()).getYears();
		System.out.println("@PostLoad called to calculate Person.age = " + age);   
	}	
	
	@PrePersist
	@PreUpdate
	public void setLastUpdate() {
		this.lastUpdate = LocalDateTime.now();
		System.out.println("Person#setLastUpdate() called to assign Person.lastUpdate = " + lastUpdate);   
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", age=" + age + "]";
	}	
	
}