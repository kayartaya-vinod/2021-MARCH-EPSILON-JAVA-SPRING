package com.epsilon.training.dao;

import java.util.List;

import com.epsilon.training.entity.Product;

public interface ProductDao {

	// CRUD operation (Create/Read/Update/Delete)

	public void addProduct(Product product) throws DaoException;

	public Product getProduct(int id) throws DaoException;

	public void updateProduct(Product product) throws DaoException;

	public void deleteProduct(int id) throws DaoException;

	// Queries (TBD later)

	public default List<Product> getAll() throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	public default List<Product> getByPriceRange(double min, double max) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	public default List<Product> getByBrand(String brand) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	public default List<Product> getByCategory(String category) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

}
