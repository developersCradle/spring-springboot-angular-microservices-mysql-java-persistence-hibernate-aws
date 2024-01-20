# Section 5: NEW - REST API Security

NEW - REST API Security

This section only covers most common Spring Security tasks.

# What I Learned

- [Spring Security Reference Manual](www.luv2code.com/spring-security-reference-manual)

- In background its using **Servlet Filters**

- Spring Security Model has two main methods to define security.
    - **Declarative**
    - **Programmatic**

<img src="springWtihServletFilter.JPG"  alt="alt text" width="500"/>

1. Most functionality comes from servlet filters

### Overview Spring Security

<img src="overviewSpringSecurity.JPG"  alt="alt text" width="500"/>

1. Web Browser wants access `2.` and get results
3. Spring Security catches query and resolves, if request is allow or not
4. Applications Security Configuration is being looked and `users` `passwords` `roles` from db if this user have been authenticated and also is this user authorized to access this resource.

<img src="workFlowOfSpringSecurity.JPG"  alt="alt text" width="500"/> 

- `Authentication` if users and password stored in db
- `Authorization` if user has authorized role

- Declarative Security is configured with `@Configuration`
- Spring can extend basic Spring Security specific enterprise company needs

- Enabling Spring Security

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

- Defaults: username: `user` and password can be found in the logs

- This can be changed configuring `application.properties`

```
spring.security.user.name=scott
spring.security.user.password=tiger
```

<img src="authenticantionAndAuthorization.JPG"  alt="alt text" width="500"/> 

1. There are many ways to do authentication and authorization. This course will cover **DB as plain-text and encrypted**

<img src="step1.JPG"  alt="alt text" width="500"/> 

<br>

- For Spring Security Password

<img src="SpringSecurityPasswordStorage.JPG"  alt="alt text" width="500"/> 

1. We be using this

<img src="addingUsers.JPG"  alt="alt text" width="500"/> 

- We are going save Users in memory

- Example using **InMemoryUserManager**

```
@Configuration
public class DemoSecurityConfig {

		@Bean
		public InMemoryUserDetailsManager userDetailsManager() { //In memory authentication
			
			UserDetails john = User.builder()
					.username("john")
					.password("{noop}test123") //Noop means plain text
					.roles("EMPLOYEE")
					.build();
			
			UserDetails mary = User.builder()
					.username("mary")
					.password("{noop}test123") //Noop means plain text
					.roles("EMPLOYEE", "MANAGER")
					.build();
			
			UserDetails susan = User.builder()
					.username("susan")
					.password("{noop}test123") //Noop means plain text
					.roles("EMPLOYEE", "MANAGER", "ADMIN")
					.build();
			
			return new InMemoryUserDetailsManager(john, mary, susan); 
		}
}
```

<img src="inPostMan.JPG"  alt="alt text" width="500"/> 

1. In postman user and password is inputted into such.
2. Whiteout credentials we are having `401 Unauthorized`
3. By default Spring uses `Basic Auth`

- We can restrict endpoints based on ROLES, we will do such

<img src="example.PNG"  alt="alt text" width="500"/> 

- We can specify restrict access by `requestMatchers(add path here).hasRole(add role here)`
	- We can specify also for other HTTP verbs

- Example using "EMPLOYEE" role

<img src="exampleForRole.PNG"  alt="alt text" width="500"/> 

1. `**` is **wild card** and we can use it to refer all rest paths

<img src="csrf.PNG"  alt="alt text" width="500"/> 

- When to use CSRF Protection

<img src="whenToUseCSRF.PNG"  alt="alt text" width="500"/> 

1. Recommended generally
2. Non-browsers usually disabled