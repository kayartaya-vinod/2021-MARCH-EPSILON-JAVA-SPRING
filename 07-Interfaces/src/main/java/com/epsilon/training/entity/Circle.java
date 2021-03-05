package com.epsilon.training.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// a class implementing an interface is equivalent to
// a class extending an abstract class
// By implementing an interface, the class abides by the rules (contract) defined by the interface

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Circle implements Shape {

	private double radius;

	@Override
	public double getArea() {
		return Shape.PI * this.radius * this.radius;
	}

	@Override
	public void info() {
		log.debug("Class Circle by Vinod Kumar K <vinod@vinod.co>");
		log.debug("Radius = {} units", this.radius);
	}

}
