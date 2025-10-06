package com.luv2code.springcoredemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2code.springcoredemo.common.SwimCoach;
import com.luv2code.util.Coach;

@Configuration
public class SportConfig {
	
	@Bean("aquatic")
	public Coach swimCoach() { // bean id default method name
		return new SwimCoach();
	}
}