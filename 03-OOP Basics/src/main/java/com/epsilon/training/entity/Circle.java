package com.epsilon.training.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Circle {

	// non-static variables/members; memory allocated every time an object is created
	private int x;
	private int y;
	private double radius;
	
	// static member (does not belong to the objects, but belongs to the class)
	// memory allocated when the class is loaded into JVM
	// not allocated in the heap; but in code segment (along with loaded class definitions)
	private static double PI = 3.14156;

	public Circle(int x, int y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public void printArea() {
		double area = Circle.PI * this.radius * this.radius;
		System.out.println("Area of circle with radius of " + radius + " units is " + area + " sq.units.");
	}

}
