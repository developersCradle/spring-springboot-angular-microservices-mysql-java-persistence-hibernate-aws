package com.luv2code.springboot.cruddemo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
	@Override
	public List<Employee> findAll() {
		Page<Employee> findAll = employeeRepository.findAll(PageRequest.ofSize(2));
		
		return findAll.toList();
	}

//	@Override
//	public List<Employee> findAll() {
//		return employeeRepository.findAll();
//	}

	
	@Transactional
	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> findById = employeeRepository.findById(theId);
		Employee theEmployee = null;
		
		if (findById.isPresent()) {
			theEmployee = findById.get();
		}
		else {
			throw new RuntimeException("Did not find employ id - " + theId);
		}
		
		return theEmployee;
	}
	
	//We need add @Transactional here
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		 return employeeRepository.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
	
}
