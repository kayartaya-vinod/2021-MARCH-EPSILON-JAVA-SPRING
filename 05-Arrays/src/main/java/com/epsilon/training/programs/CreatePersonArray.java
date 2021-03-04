package com.epsilon.training.programs;

import com.epsilon.training.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatePersonArray {

	public static void main(String[] args) {
		// people is a reference to an array of 3 Person references (not objects)
		Person[] people = new Person[3];

		log.debug("people is of type {}", people.getClass().getName());
		log.debug("people contains {} elements", people.length);

		people[0] = new Person("Vinod", 47, 5.8);

		for (int i = 0; i < people.length; i++) {
			log.debug("people[{}] = {}", i, people[i]);
		}
		
		Person p1 = new Person("Ramesh", 33, 5.9);
		Person p2 = new Person("Harish", 42, 5.7);
		
		people = new Person[] {
			new Person("John Doe", 38, 6.2),
			new Person("Shyam Sundar", 48, 6.3),
			new Person("Vinod", 47, 5.8), 
			p1, 
			p2
		};
		
		p1.setName("Ramesh Iyer");
		people[3].setAge(35);
		
		for (int i = 0; i < people.length; i++) {
			log.debug("people[{}] = {}", i, people[i]);
		}
		
		log.debug("p1 = {}", p1);
	}

}
