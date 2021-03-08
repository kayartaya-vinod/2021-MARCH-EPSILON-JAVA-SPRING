package com.epsilon.training.dao;

import java.util.List;

import com.epsilon.training.entity.Product;

public interface ProductDao {
	
	// CRUD operation (Create/Read/Update/Delete)
	
	public void addProduct(Product product);

	public Product getProduct(int id);

	public void updateProduct(Product product);

	public void deleteProduct(int id);

	// Queries (TBD later)
	
	public List<Product> getAll();
	
	public List<Product> getByPriceRange(double min, double max);
	
	public List<Product> getByBrand(String brand);
	
	public List<Product> getByCategory(String category);
	

}
