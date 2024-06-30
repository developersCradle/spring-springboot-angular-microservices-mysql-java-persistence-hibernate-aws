package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.luv2code.util.Coach;

@Component
@Primary
public class TrackCoach implements Coach {

	
	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5K!";
	}

}
