package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	
	Employee findById(int theId);
	Employee save(Employee theEmployee);
	void deleteById(int theId);
}
