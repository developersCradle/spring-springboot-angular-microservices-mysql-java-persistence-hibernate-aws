package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.luv2code.util.Coach;

@Component
public class TrackCoach implements Coach {
	
	public TrackCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5K!";
	}

}
