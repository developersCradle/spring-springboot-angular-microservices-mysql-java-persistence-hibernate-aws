package com.inw8minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//Class talks to repository
@Repository
public class CourseJdbcRepository {
	
	@Autowired
	JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY =
			"""
				insert into course (id, name, author)
				values(1, 'Learn AWS', 'in28minutes');
			""";
	

	public void insert() {
		springJdbcTemplate.update(INSERT_QUERY);
	}

}
