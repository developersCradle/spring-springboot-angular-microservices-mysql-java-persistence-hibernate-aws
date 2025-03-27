package entity;

import java.io.Serializable;
import java.util.Objects;

public class A implements Serializable {

    private String name;
    private Integer age;

    public A() {}    
    public A(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
    
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		A other = (A) obj;
		return Objects.equals(age, other.age) && Objects.equals(name, other.name);
	}

}
