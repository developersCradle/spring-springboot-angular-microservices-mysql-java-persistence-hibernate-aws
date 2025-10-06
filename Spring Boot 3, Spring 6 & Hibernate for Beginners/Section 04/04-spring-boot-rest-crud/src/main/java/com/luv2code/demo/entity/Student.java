package com.luv2code.demo.entity;

public class Student {

	
	private String firstName;
	private String lastaName;
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastaName() {
		return lastaName;
	}
	
	public void setLastaName(String lastaName) {
		this.lastaName = lastaName;
	}
	
	
	public Student()
	{
		
	}
	
	
	public Student(String firstName, String lastaName) {
		this.firstName = firstName;
		this.lastaName = lastaName;
	}
	
	
	
}
