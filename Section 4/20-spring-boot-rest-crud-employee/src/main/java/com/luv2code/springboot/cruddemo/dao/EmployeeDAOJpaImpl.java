package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

	
	//EntityManager is automatically created
	private EntityManager entityManager;
	
	
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager)
	{
		this.entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {

		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	
}
