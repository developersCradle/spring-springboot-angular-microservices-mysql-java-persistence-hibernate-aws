package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

import com.luv2code.util.Coach;


@Component
public class TennisCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand vollye";
	}

}
