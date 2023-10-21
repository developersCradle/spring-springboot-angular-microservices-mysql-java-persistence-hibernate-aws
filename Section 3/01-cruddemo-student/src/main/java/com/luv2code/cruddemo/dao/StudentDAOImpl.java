package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

// Adds support for component scanning and Translates JDBC exceptions
@Repository
public class StudentDAOImpl implements StudentDAO {

	
	private EntityManager entityManager;
	
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



//Transactional since performing an update
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent); // Saves Student to database
	}



	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}



	@Override
	public List<Student> findAll() {
		//Create query
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

		//Return query results
		return theQuery.getResultList();
	}



	@Override
	public List<Student> findByLastName(String theLastName) {
	
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
		
		theQuery.setParameter("theData", theLastName);
		
		return theQuery.getResultList();
	}



	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}



	@Override
	@Transactional
	public void delete(Integer studentId) {

		Student theStudent = entityManager.find(Student.class, studentId);
		
		
		entityManager.remove(studentId);
		
	}



	@Override
	@Transactional
	public int deleteAll(Integer studentId) { // Jäin tähän
		
		int numRowsDelted = entityManager.createNamedQuery("DELTE FROM Student").executeUpdate();
		
		return numRowsDelted;
	}

}





