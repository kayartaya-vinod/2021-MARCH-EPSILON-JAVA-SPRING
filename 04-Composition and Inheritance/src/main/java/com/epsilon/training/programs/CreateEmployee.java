package com.epsilon.training.programs;

import com.epsilon.training.entity.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateEmployee {

	public static void main(String[] args) {
		
		Employee e1, e2;
		
		log.debug("creating an employee with default constructor");
		e1 = new Employee();
		
		log.debug("creating an employee with parameterized constructor");
		e2 = new Employee(1023, "John Doe", "johndoe@xmpl.com", "Dallas", 2300, "ADMIN");
		
		log.debug("e1 is {}", e1);
		log.debug("e2 is {}", e2);
				
		e1.print();
		System.out.println("-----------------------------");
		e2.print();
	}
}
