package com.love2code.hibernate.demo;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.entity.Student;


public class CreateStudentImagesSetDemo {

	public static void main(String[] args) {

		// Create session factory.
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		// Create session.
		Session session = factory.getCurrentSession();
		
		try {
			
			// Create the object.
			Student tempStudent = new Student("FirstName", "SecondName", "paul@luv2code.com");
			Set<String> theImages = tempStudent.getImages();
			
			theImages.add("SomePic1.jpg");
			theImages.add("SomePic2.jpg");
			theImages.add("SomePic3.jpg");
			theImages.add("SomePic4.jpg");
			theImages.add("SomePic5.jpg");
			theImages.add("SomePic5.jpg"); // Will not be in Set, no duplicates in Set at Java level.
		
			// Start transaction.
			session.beginTransaction();
			
			// Save the object.
			System.out.println("Saving the student with images..");
			session.persist(tempStudent);
			
			// Commit the transaction.
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		} finally {
			// Cleanup the code.
			session.close();
			factory.close();
		}
				
	}
	
}
