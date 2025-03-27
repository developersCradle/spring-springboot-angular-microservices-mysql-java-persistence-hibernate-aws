package entity;

import jakarta.persistence.Entity;

@Entity
public class Cat extends Animal {	
	
	//Used in Question1Client
	/*
	@Column(name="purring_level")
	private Integer purringLevel;
	public void setPurringLevel(Integer purringLevel) {
		this.purringLevel = purringLevel;
	}
	*/	
	
	@Override
	public String makeNoise() {
		return "meow meow..";
	}
	
}




