package com.luv2code.cruddemo.dao;



import java.util.List;

import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	//Reading Object
	Student findById(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String theLastName);

	void update(Student theStudent);

	void delete(Integer studentId);
	
	void deleteAll(Integer studentId);
	
	//Its better to use Interger to able get null and errors in same message
}
