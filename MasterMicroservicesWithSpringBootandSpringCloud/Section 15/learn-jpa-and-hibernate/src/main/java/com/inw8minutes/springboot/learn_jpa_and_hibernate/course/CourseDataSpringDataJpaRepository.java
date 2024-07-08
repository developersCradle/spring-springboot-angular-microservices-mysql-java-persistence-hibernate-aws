package com.inw8minutes.springboot.learn_jpa_and_hibernate.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDataSpringDataJpaRepository extends JpaRepository<Course, Long>{

	List<Course>findByAuthor(String auhor);
	List<Course>findByName(String name);
}
