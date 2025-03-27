package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
//@Inheritance(strategy=InheritanceType.JOINED) // to be used when you want to test JOINED strategy for inheritance mapping
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) // to be used when you want to test TABLE_PER_CLASS (Table Per Concrete Class) strategy for inheritance mapping
public abstract class Animal {
	
	//1. Before Hibernate 5.x, GenerationType.AUTO used GenerationType.IDENTITY as default strategy
	//2. After Hibernate 5.x, GenerationType.AUTO used GenerationType.SEQUENCE as default strategy
	//3. To follow the course with Hibernate 6.y, use GenerationType.IDENTITY strategy explicitly
	//4. Q&A on AUTO vs IDENTITY: https://www.udemy.com/course/hibernate-and-jpa-fundamentals/learn/lecture/26324154#questions/937412
	//5. In the lecture on "Pre-INSERT Identifier Generation", we talk more about AUTO, IDENTITY, SEQUENCE and TABLE strategies
	//6. @GeneratedValue(strategy=GenerationType.TABLE) to be used when using TABLE_PER_CLASS strategy
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ID")	
	private Long id;
	
	//@Column(nullable=false) // cannot be used when using SINGLE_TABLE strategy
	private String name;	
	
	public void setName(String name) { 	
		this.name = name; 
	}
	
	public abstract String makeNoise();
	
	public String toString() {
		return name + " making " + makeNoise() + " noises";
	}	

}
