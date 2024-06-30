package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

import com.luv2code.util.Coach;

@Component
public class BaseballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in batting practice";
	}

}
