package com.epsilon.training.programs;

import java.util.InputMismatchException;

import com.epsilon.training.dao.DaoFactory;
import com.epsilon.training.dao.ProductDao;
import com.epsilon.training.entity.Product;
import com.epsilon.training.utils.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;
import sun.security.util.KeyUtil;

@Slf4j
public class ProductManagerApplication {

	ProductDao dao;

	void start() {
		// tight coupling; must be avoided - Use a factory method (virtual constructor)
		// dao = new DummyProductDao();
		dao = DaoFactory.getProductDao();

		while (true) {
			menu();
			try {
				int choice = KeyboardUtil.getInt("Enter your choice: ");
				if (choice == 0) {
					System.out.println("Thank you and have a nice day.");
					break;
				}

				switch (choice) {
				case 1:
					acceptAndAddProductDetails();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					System.out.println("Invalid choice! Please try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}

	void acceptAndAddProductDetails() {
		
		// create a product object
		// use the addProduct function in dao object
		
		try {
			// create variables for all product fields
			// accept value for each variable from the user
			int id = KeyboardUtil.getInt("Enter id: ");
			String name = KeyboardUtil.getString("Enter product name: ");
			String description = KeyboardUtil.getString("Enter product description: ");
			
			Product p = new Product();
			p.setId(id);
			p.setName(name);
			p.setDescription(description);
			
			// TODO do the same for rest of the fields
			
			dao.addProduct(p);
			System.out.println("New product details added to successfully!");
		}
		catch(Exception ex) {
			log.warn("There was an error while trying to add a product");
			log.warn(ex.getMessage());
		}
	}

	void menu() {
		System.out.println("*** Main Menu ***");
		System.out.println("0. Exit");
		System.out.println("1. Add a new product");
		System.out.println("2. Retrieve a product by id");
		System.out.println("3. Modify details of a product");
		System.out.println("4. Remove product details");
	}

	public static void main(String[] args) {
		new ProductManagerApplication().start();
	}

}
