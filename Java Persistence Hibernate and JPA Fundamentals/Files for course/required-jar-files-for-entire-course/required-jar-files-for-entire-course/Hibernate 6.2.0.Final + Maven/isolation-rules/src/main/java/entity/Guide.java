package entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.BatchSize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
@BatchSize(size=2)
public class Guide {

	//1. Before Hibernate 5.x, GenerationType.AUTO used GenerationType.IDENTITY as default strategy
	//2. After Hibernate 5.x, GenerationType.AUTO used GenerationType.SEQUENCE as default strategy
	//3. To follow the course with Hibernate 6.y, use GenerationType.IDENTITY strategy explicitly
	//4. Q&A on AUTO vs IDENTITY: https://www.udemy.com/course/hibernate-and-jpa-fundamentals/learn/lecture/26324154#questions/937412
	//5. In the lecture on "Pre-INSERT Identifier Generation", we talk more about AUTO, IDENTITY, SEQUENCE and TABLE strategies
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ID")	
	private Long id;
	
	@Column(name="staff_id", nullable=false)
	private String staffId;	
	
	private String name;
	private Integer salary;
	
	//when you're altering the schema of your tables to add the version column to use versioning, don't forget to add the default for that column as 0 like ALTER TABLE `guide` ADD `version` INT(11) NOT NULL DEFAULT '0'; 
	@Version
	private Integer version;

	//but if you're planning to use versioning right from the beginning, it's always good to have @Column(columnDefinition = "integer DEFAULT 0", nullable = false)  mapping added along with the @Version  annotation at the private Integer version;  attribute. It is to define that the column is non-nullable and its default value is 0.
	/*
	@Column(columnDefinition = "integer DEFAULT 0", nullable = false) 
	@Version
	private Integer version;
	*/

	@OneToMany(mappedBy="guide", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Student> students = new HashSet<Student>();	
	
	public Guide() {}
	public Guide(String staffId, String name, Integer salary) {
		this.staffId = staffId;
		this.name = name;
		this.salary = salary;
	}
	
	public Set<Student> getStudents() {
		return students;
	}	

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public String getStaffId() {
		return staffId;
	}
	public Integer getSalary() {
		return salary;
	}
	
	public void addStudent(Student student) {
		students.add(student);
		student.setGuide(this);
	}
	
	@Override
	public String toString() {
		return "Guide [id=" + id + ", staffId=" + staffId + ", name=" + name + ", salary=" + salary + "]";
	}	

}