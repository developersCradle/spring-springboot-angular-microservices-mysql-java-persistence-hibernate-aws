package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private Coach myCoach;
	
	
	// If only one @Autowired no configuration not needed
	
	@Autowired
	public DemoController(Coach theCoach) {
		myCoach = theCoach;
	}
	
	
	
	
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
		
	}
}
