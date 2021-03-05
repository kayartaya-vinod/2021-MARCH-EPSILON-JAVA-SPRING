package com.epsilon.training.dao;

import com.epsilon.training.entity.Product;

public interface ProductDao {
	
	// CRUD operation (Create/Read/Update/Delete)
	
	public void addProduct(Product product);

	public Product getProduct(int id);

	public void updateProduct(Product product);

	public void deleteProduct(int id);

	// Queries (TBD later)
	
	

}
