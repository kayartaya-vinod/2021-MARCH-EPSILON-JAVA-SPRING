package com.epsilon.training.programs;

import com.epsilon.training.entity.Employee;
import com.epsilon.training.entity.InvalidIdException;
import com.epsilon.training.entity.InvalidNameException;
import com.epsilon.training.entity.InvalidSalaryException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateEmployees {

	public static void main(String[] args) {

		Employee e1;

		try {
			e1 = new Employee();

			e1.setId(123);
			e1.setName("Jacob");
			e1.setSalary(4500);

			log.debug("e1 is {}", e1);
			log.debug("e1.id is {}", e1.getId());
			log.debug("e1.name is {}", e1.getName());
			log.debug("e1.salary is {}", e1.getSalary());

		} catch (InvalidIdException e) {
			log.warn("Problem with id - {}", e.getMessage());
		} catch (InvalidNameException e) {
			log.warn("Problem with name - {}", e.getMessage());
		} catch (InvalidSalaryException e) {
			log.warn("Problem with salary - {}", e.getMessage());
		} catch (Exception e) {
			log.warn("There was an error - {}", e.getMessage());

		}

	}
}
