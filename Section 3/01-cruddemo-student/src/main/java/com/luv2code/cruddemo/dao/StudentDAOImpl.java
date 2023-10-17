package com.luv2code.cruddemo.dao;

import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
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

}





