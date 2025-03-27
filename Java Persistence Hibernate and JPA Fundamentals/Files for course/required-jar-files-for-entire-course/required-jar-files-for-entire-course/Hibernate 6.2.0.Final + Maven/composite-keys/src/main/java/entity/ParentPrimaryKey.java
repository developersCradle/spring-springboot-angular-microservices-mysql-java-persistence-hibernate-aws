package entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ParentPrimaryKey implements Serializable {
	
	private String firstname;
	private String lastname;
	
	public ParentPrimaryKey() {}	
	public ParentPrimaryKey(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}	
	
	@Override
	public int hashCode() {
		int result = firstname.hashCode();
		result = 31 * result + lastname.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;		
		ParentPrimaryKey parentPrimaryKey = (ParentPrimaryKey) o;		
		if (!firstname.equals(parentPrimaryKey.firstname)) return false;		
		if (!lastname.equals(parentPrimaryKey.lastname)) return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ParentPrimaryKey [firstname=" + firstname + ", lastname=" + lastname + "]";
	}	
	
}
