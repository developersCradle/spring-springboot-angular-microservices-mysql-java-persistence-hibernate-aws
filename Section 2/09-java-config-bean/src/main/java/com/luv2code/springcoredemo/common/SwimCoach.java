package com.luv2code.springcoredemo.common;

import com.luv2code.util.Coach;

public class SwimCoach implements Coach{

	
	public SwimCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up";
	}

}
