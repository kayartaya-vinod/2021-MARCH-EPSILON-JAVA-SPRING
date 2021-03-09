package com.epsilon.training.programs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.epsilon.training.entity.Customer;

public class ReadCustomersCSV {

	public static void main(String[] args) throws Exception {
		String filename = "customers.csv";

		try (FileReader file = new FileReader(filename); BufferedReader in = new BufferedReader(file);) {

			String line;
			// skip the header
			in.readLine(); // ignore the return value
			List<Customer> customers = new ArrayList<>();
			while ((line = in.readLine()) != null) {
				String[] values = line.split(",");
				Customer c = new Customer(values);
				customers.add(c);
			}

		}
	}

}
