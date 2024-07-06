# Section 15: Appendix - Introduction to JPA in 10 Steps - V2

Introduction JPA

# 293. Step 01 - Getting Started with JPA and Hibernate - Goals

- Plan here.

<img src="plan1.PNG" alt="Course here" width="600"/>

<img src="plan2.PNG" alt="Course here" width="600"/>

# 294. Step 02 - Setting up New Spring Boot Project for JPA and Hibernate

- Got working Spring app with Spring Initializer ✅ 

# 295. Step 03 - Launching up H2 Console and Creating Course Table in H2

- We enable **h2** console via configuration. With configuration, no need to copy from console every time.

# application.properties
```
spring.application.name=learn-jpa-and-hibernate
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
```

- For creating tables in **H2**, we create following **schema**. This this file automatically picked up by **H2**.

```
create table course
{
	id bigint not null, 
	name varchar(255) not null,
	author varchar(255) not null,
	primary key (id)
};
```

- **Long** in Java translate into **bigint** in **H2**.
- **String** in Java translate into **varchar()** in **H2**.

# 296. Step 04 - Getting Started with Spring JDBC

- We are writing **SQL queries** in **JDBC** and **Spring JDBC**. 

<img src="jdbcAndSpringJDBC.PNG" alt="Course here" width="600"/>

1. With **Spring JDBC** you need write **less java code**. 

<img src="differenceBetweenJDBCandSpringJDBC.PNG" alt="Course here" width="600"/>

1. In **JDBC**.
2. In **Spring JDBC**.

# 297. Step 05 - Inserting Hardcoded Data using Spring JDBC

- In **Spring** class which talks to database is usually **Repository**.

```

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

```

- **.update** can be used to execute **insert**, **update** or **delete** queries.

- We can use query at startup. **SpringBoot** provides concept like **CommandLineRunner**. Example below as following:

```

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert();
	}

}

```

# 298. Step 06 - Inserting and Deleting Data using Spring JDBC