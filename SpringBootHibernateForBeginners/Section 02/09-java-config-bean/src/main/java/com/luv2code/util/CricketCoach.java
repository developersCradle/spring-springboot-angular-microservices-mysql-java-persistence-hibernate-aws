package com.luv2code.util;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes :)";
	}

}
