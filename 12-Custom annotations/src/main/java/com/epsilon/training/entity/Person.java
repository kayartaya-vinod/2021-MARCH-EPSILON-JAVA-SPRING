package com.epsilon.training.entity;

import com.epsilon.training.annotations.JsonProperty;
import com.epsilon.training.annotations.JsonSerializable;

@JsonSerializable()
public class Person {
	@JsonProperty(label = "fname")
	private String firstname;
	@JsonProperty(label="lname")
	private String lastname;
	private int age;
	@JsonProperty
	private double height;
	@JsonIgnored
	private double weight;

	public Person() {
	}

	public Person(String firstname, String lastname, int age, double height) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.height = height;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", height=" + height
				+ ", weight=" + weight + "]";
	}

}
