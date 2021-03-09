package com.epsilon.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
	private int id;
	private String firstname;
	private String lastname;
	private String gender;
	private String phone;
	private String email;
	private String city;

	public Customer(String[] values) {
		this.id = Integer.parseInt(values[0]);
		this.firstname = values[1];
		this.lastname = values[2];
		this.gender = values[3];
		this.phone = values[4];
		this.email = values[5];
		this.city = values[6];
	}
	
	public void print() {
		System.out.printf("ID           : %d\n", this.id);
		System.out.printf("Name         : %s %s\n", this.firstname, this.lastname);
		System.out.printf("Gender       : %s\n", this.gender);
		System.out.printf("Phone        : %s\n", this.phone);
		System.out.printf("Email id     : %s\n", this.email);
		System.out.printf("City         : %s\n", this.city);
		System.out.println();
		
	}
}
