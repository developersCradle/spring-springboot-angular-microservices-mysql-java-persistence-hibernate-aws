package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(A.class)
public class B{

    @Id
    private String name;

    @Id
    private Integer age;

    private String foo;    
    
    public B() {}
    public B(String name, Integer age, String foo) {
		this.name = name;
		this.age = age;
		this.foo = foo;
	}
    
	@Override
	public String toString() {
		return "B [name=" + name + ", age=" + age + ", foo=" + foo + "]";
	}
    
}
