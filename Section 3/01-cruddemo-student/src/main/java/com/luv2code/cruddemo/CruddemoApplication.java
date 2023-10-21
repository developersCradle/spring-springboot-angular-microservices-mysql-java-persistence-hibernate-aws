package com.luv2code.cruddemo;

import java.util.Iterator;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {
//			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStuden(studentDAO);
			deleteStudent(studentDAO);
		};
	}
	

	private void deleteStudent(StudentDAO studentDAO) {

		
		Integer studentID = 3;
		
		System.out.println("Deleting studet id: " + studentID);
		studentDAO.delete(studentID);
	
	
	}


	private void updateStuden(StudentDAO studentDAO) {

		int studetId = 1;
		
		System.out.println("Getting student with id: " + studetId);
		Student myStudent = studentDAO.findById(studetId);
		
		
		System.out.println("Updating student...");
		myStudent.setFirstName("Scoopy");
		
		studentDAO.update(myStudent);
		System.out.println("UpdateD student " + myStudent);
	}


	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		System.out.println("queryForStudentsByLastName alkaa");
		for (Student tempStudent : theStudents ) {
			System.out.println(tempStudent);
		}
	}


	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findAll();
	
		for (Student tempStudent : theStudents) {
			
			System.out.println(tempStudent);
		}
	
	}


	private void readStudent(StudentDAO studentDAO) {
		
		System.out.println("Creating new student obkect ...");
		Student tempStudent = new Student( "Daffy", "Duck", "daffy@luv2code.com");

		System.out.println("Saving the student ... ");
		studentDAO.save(tempStudent);
		
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id " + theId);
		
		
		System.out.println("Retrieving student with id: "  + theId);
		Student myStudent = studentDAO.findById(theId);
		
		System.out.println("Found the student: " + myStudent);
	}


	private void createMultipleStudent(StudentDAO studentDAO) {
		
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student( "John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student( "Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student( "Bonita", "Applebum", "bonita@luv2code.com");
		
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}


	private Object createStudent(StudentDAO studentDAO) {
		
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student( "Paul", "Doe", "Paul@luv2code.com");
		
		
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
		
		return null;
	}

}
