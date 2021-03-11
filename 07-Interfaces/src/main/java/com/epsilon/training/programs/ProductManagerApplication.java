package com.epsilon.training.programs;

import java.util.InputMismatchException;

import com.epsilon.training.dao.DaoException;
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
					acceptAndUpdateProduct();
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

	private void acceptAndUpdateProduct() {
		 int id = KeyboardUtil.getInt("Enter the product id: ");
		
		try {
			Product p = dao.getProduct(id);
			if (p == null) {
				System.out.println("No product data found for id " + id);
			} else {
				// display product fields and ask for modification
				String input;
				input = getUserInput("Name", p.getName());
				p.setName(input);
				
				input = getUserInput("Brand", p.getBrand());
				p.setBrand(input);
				
				input = getUserInput("Category", p.getCategory());
				p.setCategory(input);
				
				input = getUserInput("Description", p.getDescription());
				p.setDescription(input);
				
				input = getUserInput("Quantity per unit", p.getQuantityPerUnit());
				p.setQuantityPerUnit(input);
				
				input = getUserInput("Picture", p.getPicture());
				p.setPicture(input);
				
				input = getUserInput("Unit price", p.getUnitPrice());
				p.setUnitPrice(Double.parseDouble(input));
				
				input = getUserInput("Discount", p.getDiscount());
				p.setDiscount(Double.parseDouble(input));
				
				log.debug("Product is {}", p);
				
			}
		} catch (DaoException e) {
			log.warn("There was an error - {}", e.getMessage());
		}

	}

	private String getUserInput(String fieldTitle, Object currVal) {
		String input;
		input = KeyboardUtil.getString(String.format("Enter %s: (%s) ", fieldTitle, currVal)).trim();
		if (input.equals("")) {
			return String.valueOf(currVal);
		}
		return input;
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
		} catch (Exception ex) {
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
