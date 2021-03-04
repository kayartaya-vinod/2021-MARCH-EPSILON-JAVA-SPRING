package com.epsilon.training.entity;

public class Employee {

	private int id;
	private String name;
	private double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) throws InvalidIdException {
		if (id <= 0 || id > 99999) {
			throw new InvalidIdException("Invalid id. Pleas ensure: 1 >= id >= 99999");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws InvalidNameException {
		if (name == null || name.length() < 3 || name.length() > 15) {
			throw new InvalidNameException("Name cannot be null or less than 3 letters or more than 15 letters");
		}
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) throws InvalidSalaryException {
		if (salary < 15000 | salary > 200000) {
			throw new InvalidSalaryException("Salary must be between 15000 and 200000");
		}
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
