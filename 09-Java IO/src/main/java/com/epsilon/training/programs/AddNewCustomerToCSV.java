package com.epsilon.training.programs;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.epsilon.training.utils.KeyboardUtil;

public class AddNewCustomerToCSV {

	public static void main(String[] args) throws Exception {
		FileWriter writer = null;
		PrintWriter out = null;

		try {
			String filename = "customers1.csv";
			File file = new File(filename);

			if (file.exists()) {
				// open the file for appending
				writer = new FileWriter(file, true);
				out = new PrintWriter(writer);
			} else {
				// create a new file and add header line
				String header = "id,first_name,last_name,gender,phone,email,city";
				writer = new FileWriter(file);
				out = new PrintWriter(writer);
				out.println(header);
			}

			int id = KeyboardUtil.getInt("Enter id       : ");
			String firstname = KeyboardUtil.getString("Enter firstname: ");
			String lastname = KeyboardUtil.getString("Enter lastname : ");
			String gender = KeyboardUtil.getString("Enter gender   : ");
			String phone = KeyboardUtil.getString("Enter phone    : ");
			String email = KeyboardUtil.getString("Enter email    : ");
			String city = KeyboardUtil.getString("Enter city     : ");

			out.printf("%d,%s,%s,%s,%s,%s,%s\n", id, firstname, lastname, gender, phone, email, city);
			System.out.println("Data written to the file.");
		} finally {
			if (out != null) {
				out.close();
			}
			if (writer != null) {
				writer.close();
			}
		}

	}

}
