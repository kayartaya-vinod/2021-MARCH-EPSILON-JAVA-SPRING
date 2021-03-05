package com.epsilon.training.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Triangle implements Shape {

	private double base;
	private double height;

	@Override
	public double getArea() {
		return 0.5 * this.base * this.height;
	}

	@Override
	public void info() {
		log.debug("Class Triangle create by Vinod <vinod@vinod.co>");
		log.debug("Base = {} units", this.base);
		log.debug("Height = {} units", this.height);
	}
	
	// this is not an example of overriding
	// overriding is a concept between objects and non-static methods only.
	public static void details() {
		log.debug("Details of Triangle class are listed below:");
	}
}
