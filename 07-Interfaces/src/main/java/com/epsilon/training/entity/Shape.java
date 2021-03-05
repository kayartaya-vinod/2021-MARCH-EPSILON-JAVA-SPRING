package com.epsilon.training.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// interface is equivalent to an abstract class
// with or with out abstract methods

@FunctionalInterface
public interface Shape {
	double PI = 3.14159; // public static final
	Logger log = LoggerFactory.getLogger(Shape.class);

	double getArea(); // public abstract
	
	// default, but non-static method
	// can make use of members of the implementing class
	default void info() {
		log.debug("Interface Shape created by Vinod <vinod@vinod.co>");
	}
	
	// belongs to the implementing class (not objects)
	// cannot access non-static members of implementing class
	static void details() {
		log.debug("Details of Shape interface are listed below:");
	}

}
