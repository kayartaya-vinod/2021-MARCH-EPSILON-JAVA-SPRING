package com.epsilon.training.programs;

import com.epsilon.training.entity.Person;

public class CreatePersonObjects {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.setFirstname("Vinod");
		p1.setLastname("Kumar");
		p1.setEmail("vinod@vinod.co");
		p1.setCity("Bangalore");

		Person p2 = new Person();
		p2.setFirstname("John");
		p2.setLastname("Miller");
		p2.setEmail("johnmiller@xmpl.com");
		p2.setCity("Dallas");
		
		System.out.println(p1);
		System.out.println(p2);
		
	}
}
