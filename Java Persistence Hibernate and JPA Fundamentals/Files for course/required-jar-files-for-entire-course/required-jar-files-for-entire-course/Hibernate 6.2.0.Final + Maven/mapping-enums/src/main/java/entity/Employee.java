package entity;

import converter.EmployeeStatusConverter;
import enums.EmployeeStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
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
	
	@Column(name="employee_id", unique=true)
	private String employeeId;
	
	//@Convert(converter = EmployeeStatusConverter.class)
	//@Enumerated(EnumType.STRING)
	//@Enumerated(EnumType.ORDINAL)
	@Enumerated
	@Column(name="employee_status")
	private EmployeeStatus employeeStatus;

	public Employee() {}
	public Employee(String name, String employeeId, EmployeeStatus employeeStatus) {
		this.name = name;
		this.employeeId = employeeId;
		this.employeeStatus = employeeStatus;
	}
	
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", employeeId="
				+ employeeId + ", employeeStatus=" + employeeStatus + "]";
	}
	
	
	
}
