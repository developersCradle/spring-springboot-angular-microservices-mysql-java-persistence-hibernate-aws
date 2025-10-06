package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

import com.luv2code.util.Coach;


@Component
public class TennisCoach implements Coach{

	public TennisCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand vollye";
	}

}
