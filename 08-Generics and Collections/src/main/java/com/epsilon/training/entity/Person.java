package com.epsilon.training.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Person implements Comparable<Person> {
	private int id;
	private String firstname;
	private String lastname;
	private double height;
	private int weight;

	@Override
	public int compareTo(Person other) {
		// this function provides the natural ordering of Person objects

		// this method should return
		// 0 when 'this' and 'other' are equal
		// negative when 'this' is smaller than 'other'
		// positive when 'this' is bigger/greater than 'other'
		return this.id - other.id;
	}
}
