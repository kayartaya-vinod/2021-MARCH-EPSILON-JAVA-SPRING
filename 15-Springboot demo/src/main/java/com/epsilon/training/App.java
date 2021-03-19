package com.epsilon.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		// Tasks achieved:
		// 1. start Apache Tomcat (embedded container)
		// 2. create AnnotationConfigWebApplicationContext (spring container)
		// 3. load all beans defined in the class supplied as argument
		SpringApplication.run(App.class, args);
	}

}
