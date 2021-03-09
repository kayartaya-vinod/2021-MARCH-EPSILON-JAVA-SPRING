package com.epsilon.training.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvProductDao implements ProductDao {
	private static final String FILENAME = "products.csv";
	
	private Map<Integer, Product> products;

	public CsvProductDao() {
		this.products = new HashMap<>();

		File file = new File(FILENAME);
		if (file.exists()) {
			try (FileReader reader = new FileReader(file); BufferedReader in = new BufferedReader(reader);) {

				// skip header
				in.readLine();
				String line;
				while ((line = in.readLine()) != null) {
					// convert one line into one product and add to the map
					Product p = createProduct(line);
					if (p != null) {
						products.put(p.getId(), p);
					}

				}
			} catch (Exception ex) {
				// exception ducking; ignoring the runtime error
				log.warn("There was an error - {}", ex.getMessage());
			}
		}
	}

	private Product createProduct(String line) {
		try {
			String[] vals = line.split(",");
			Product p = new Product();
			p.setId(Integer.parseInt(vals[0]));
			p.setCategory(vals[1]);
			p.setName(vals[2]);
			p.setBrand(vals[3]);
			p.setDescription(vals[4]);
			p.setQuantityPerUnit(vals[5]);
			p.setUnitPrice(Double.parseDouble(vals[6]));
			p.setPicture(vals[7]);
			p.setDiscount(Double.parseDouble(vals[8]));
			return p;
		} catch (NumberFormatException e) {
			log.warn("Error - {}", e.getMessage());
			return null;
		}
	}

	@Override
	public void addProduct(Product product) throws DaoException {
		
		products.put(product.getId(), product);
		// write the entire content of the map to the file.
		writeToFile();

	}

	private void writeToFile() throws DaoException {
		String header = "id,category,name,brand,description,quantity_per_unit,unit_price,picture,discount";
		try(FileWriter writer = new FileWriter(FILENAME);
			PrintWriter out = new PrintWriter(writer);){
			out.println(header);
			
			for(Product p: products.values()) {
				out.printf("%d,%s,%s,%s,%s,%s,%.2f,%s,%.2f\n",
						p.getId(),
						p.getCategory(),
						p.getName(),
						p.getBrand(),
						p.getDescription(),
						p.getQuantityPerUnit(),
						p.getUnitPrice(),
						p.getPicture(),
						p.getDiscount());
			}
		}
		catch(Exception ex) {
			log.warn("Error - {}", ex.getMessage());
			throw new DaoException(ex);
		}
	}

	@Override
	public Product getProduct(int id) throws DaoException {
		Product p = products.get(id);
		if (p == null) {
			throw new DaoException("No product found with id " + id);
		}
		return p;
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		products.replace(product.getId(), product);
		writeToFile();
	}

	@Override
	public void deleteProduct(int id) throws DaoException {
		products.remove(id);
		writeToFile();
	}

	@Override
	public List<Product> getAll() throws DaoException {
		List<Product> list = new ArrayList<>();
		list.addAll(this.products.values());
		return list;
	}

	@Override
	public List<Product> getByPriceRange(double min, double max) throws DaoException {
		return ProductDao.super.getByPriceRange(min, max);
	}

	@Override
	public List<Product> getByBrand(String brand) throws DaoException {
		return ProductDao.super.getByBrand(brand);
	}

	@Override
	public List<Product> getByCategory(String category) throws DaoException {
		return ProductDao.super.getByCategory(category);
	}

}
