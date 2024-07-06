package com.in28minutes.microservices.limit_service.bean;

public class Limits {

	private int minimum;
	private int maximum;

	public Limits() {
		super();
	}

	public Limits(int min, int max) {
		super();
		this.minimum = min;
		this.maximum = max;
	}

	public int getMax() {
		return maximum;

	}

	public void setMax(int max) {
		this.maximum = max;
	}

	public int getMin() {
		return minimum;
	}

	public void setMin(int min) {
		this.minimum = min;
	}
}
