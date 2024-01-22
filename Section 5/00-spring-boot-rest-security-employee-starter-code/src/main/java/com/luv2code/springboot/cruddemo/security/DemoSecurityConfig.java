package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	
	// Add support for JDBC
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	
/*
		@Bean
		public InMemoryUserDetailsManager userDetailsManager() { //In memory authentication

			
			//Commeting out old hard-coded users
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

		*/
		
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception  {
			
			
			//Setting up rules
			http.authorizeHttpRequests( configurer ->
			configurer
				.requestMatchers(HttpMethod.GET, "api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "api/employees/**").hasRole("ADMIN")
				
			);
			
			// use HTTP Basic authentication
			http.httpBasic(Customizer.withDefaults());
			
			//Disable SRRF for REST in general
			http.csrf(csrf -> csrf.disable());
			
			
			return http.build();

		}
}
