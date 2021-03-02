package com.epsilon.training.programs;

import com.epsilon.training.entity.Circle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateCircles {

	public static void main(String[] args) {
		log.info("start of main");
		Circle c1, c2;
		
		// a class is loaded into JVM in many ways
		// 1. by creating an object (to calculate the memory required by an object)
		// 2. by manually loading the class into JVM --> Class.forName("name of the class");
		
		c1 = new Circle(); // 16 bytes allocated in heap
		log.info("created circle object 1");
		c2 = new Circle(12, 34, 100.0); // 16 bytes allocated in heap
		log.info("created circle object 2");
		
		c1.printArea();
		c2.printArea();
		
		log.info("end of main");
	}
}
