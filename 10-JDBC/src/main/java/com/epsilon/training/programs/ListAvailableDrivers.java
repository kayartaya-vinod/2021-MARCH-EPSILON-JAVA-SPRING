package com.epsilon.training.programs;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class ListAvailableDrivers {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// DriverManager is a factory class for manufacturing Connection instances
		// DriverManager maintains a list of Driver instances 
		// You can register any Driver instance in two ways:
		// 1. create an object of a class that implements java.sql.Driver and then call
		//    the DriverManager.registerDriver function
		// 2. use the Class.forName function that loads the driver class, which automatically
		//    registers an instance of itself.
		// Most modern JDBC implementations automatically register their driver by
		// simply adding the JAR file into the CLASSPATH or build path
		
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		System.out.println("Here are the registered drivers: ");
		while(drivers.hasMoreElements()) {
			Driver d = drivers.nextElement();
			System.out.println(d.getClass().getName());
		}
		
		System.out.println("That's all folks!");
	}

}
