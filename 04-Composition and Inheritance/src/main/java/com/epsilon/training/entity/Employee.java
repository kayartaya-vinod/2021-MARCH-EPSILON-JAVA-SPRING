package com.epsilon.training.entity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Employee extends Person {
	private int id;
	private double salary;
	private String department;

	public Employee() {
		super(); // implicitly done; call to the superclass default (no-argument) constructor
		log.debug("Employee() called");
	}

	public Employee(int id, String name, String email, String city, double salary, String department) {
		super(name, email, city);
		this.id = id;
		this.salary = salary;
		this.department = department;
		log.debug("Employee(id, name, email, city, salary, department) called");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public static org.slf4j.Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", department=" + department + ", extends="
				+ super.toString() + "]";
	}
	
	// private, package-level, protected, public
	// while overriding, you can only increase the access (visibility); not decrease.
	@Override
	public void print() {
		System.out.println("Details of employee: ");
		System.out.println("ID          : " + id);
		super.print();
		System.out.println("Salary      : $ " + salary);
		System.out.println("Department  : " + department);
	}

}
