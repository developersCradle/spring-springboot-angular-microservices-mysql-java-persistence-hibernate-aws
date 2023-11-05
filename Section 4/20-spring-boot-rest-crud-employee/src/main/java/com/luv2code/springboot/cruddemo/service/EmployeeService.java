package com.luv2code.springboot.cruddemo.service;

import java.util.List;


import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
}
