package com.epsilon.training.programs;

import com.epsilon.training.entity.Employee;
import com.epsilon.training.entity.Person;
import com.epsilon.training.entity.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PolymorphismDemo {

	public static void main(String[] args) {
		Employee e1 = new Employee(1020, "Scott", "scott@example.com", "Newyork", 3300.0, "ACCT");
		Student s1 = new Student(9827, "Vijay", "vj@xmpl.com", "Hassan", "Computers", 3.9);
		
		log.debug("e1 instanceof Employee is {}", e1 instanceof Employee);
		log.debug("e1 instanceof Person is {}", e1 instanceof Person);
		log.debug("e1 instanceof Object is {}", e1 instanceof Object);
		
		log.debug("s1 instanceof Student is {}", s1 instanceof Student);
		log.debug("s1 instanceof Person is {}", s1 instanceof Person);
		log.debug("s1 instanceof Object is {}", s1 instanceof Object);
		
		Person p1;
		
		
		// up-casting; implicit
		p1 = e1; // no error; LHS is a reference of Person and RHS is an object of Person type
		p1.print(); // the method def of print() exists in p1's type (Person) and object's type (Employee)
		// at compile time, p1 is a variable of Person class
		// at runtime, p1 is a reference to an object of Employee class
		
		log.debug("p1 instanceof Employee is {}", p1 instanceof Employee);
		log.debug("p1 instanceof Student is {}", p1 instanceof Student);
		
		// the call p1.print() must be associated (binding) with a function def. Which one?
		// in Java, method binding happens always at runtime. (there is no early binding or compile-time binding in Java)
		System.out.println();
		p1 = s1;
		p1.print();
		
		log.debug("p1 instanceof Employee is {}", p1 instanceof Employee);
		log.debug("p1 instanceof Student is {}", p1 instanceof Student);

		
		s1 = (Student) p1; // down-casting; has to be explicit;
		
	}

}
