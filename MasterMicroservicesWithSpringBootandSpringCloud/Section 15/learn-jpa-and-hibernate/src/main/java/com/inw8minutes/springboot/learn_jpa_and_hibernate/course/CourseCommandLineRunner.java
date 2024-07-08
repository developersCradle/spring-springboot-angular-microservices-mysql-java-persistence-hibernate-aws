package com.inw8minutes.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.inw8minutes.springboot.learn_jpa_and_hibernate.course.Course;
import com.inw8minutes.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

// JDBC way to communicate database
//	@Autowired
//	private CourseJdbcRepository repository;

//JPA way to communicate database
//	@Autowired
//	private CourseDataSpringDataJpaRepository repository;

	//This one with Spring Data JPA
	@Autowired
	private CourseDataSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1,"Learn AWS Jpa!", "in28minutes"));
		repository.save(new Course(2,"Learn Azure Jpa!", "in28minutes"));
		repository.save(new Course(3,"Learn DevOps", "in28minutes"));
	
		repository.deleteById(3l);
		
		System.out.println(repository.findById(1l));
		System.out.println(repository.findById(2l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("in28minutes"));
		System.out.println(repository.findByAuthor(""));
		
		System.out.println(repository.findByName("Learn AWS Jpa!"));
		System.out.println(repository.findByAuthor("Learn Azure Jpa!"));
	}

}
