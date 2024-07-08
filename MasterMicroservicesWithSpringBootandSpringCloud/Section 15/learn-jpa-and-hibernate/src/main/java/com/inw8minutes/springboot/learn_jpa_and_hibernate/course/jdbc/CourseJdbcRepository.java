package com.inw8minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inw8minutes.springboot.learn_jpa_and_hibernate.course.Course;

//Class talks to repository
@Repository
public class CourseJdbcRepository {
	
	@Autowired
	JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY =
			"""
				insert into course (id, name, author)
				values(?, ?, ?);
			""";
	
	private static String DELTE_QUERY =
			"""
				delete from course
				where id = ?;
			""";

	private static String SELECT_QUERY =
			"""
				select * from course
				where id = ?;
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELTE_QUERY, id);
	}

	public Course findById(long id) {
		// Mapping the ResultSet to Bean 
		// Mapping is happening using Row Mappers
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
