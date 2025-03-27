package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Publisher{

	@Id
	@Column(name = "CODE", unique = true, nullable = false, length = 4)
	private String code;
	
	@Column(name = "PUBLISHER_NAME", nullable = false, length = 100)
	private String name;

	public Publisher() {}
	public Publisher(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Publisher [code=" + code + ", name=" + name + "]";
	}	
	
}