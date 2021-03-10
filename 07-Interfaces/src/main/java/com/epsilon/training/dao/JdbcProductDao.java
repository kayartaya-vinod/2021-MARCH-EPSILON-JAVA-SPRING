package com.epsilon.training.dao;

import java.util.List;

import com.epsilon.training.entity.Product;

public class JdbcProductDao implements ProductDao {

	@Override
	public void addProduct(Product product) throws DaoException {
		// TODO Implement this method using JDBC
	}

	@Override
	public Product getProduct(int id) throws DaoException {
		return null;
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		// TODO Implement this method using JDBC
	}

	@Override
	public void deleteProduct(int id) throws DaoException {
		// TODO Implement this method using JDBC
	}

	@Override
	public List<Product> getAll() throws DaoException {
		return null;
	}

	@Override
	public List<Product> getByPriceRange(double min, double max) throws DaoException {
		return null;
	}

	@Override
	public List<Product> getByBrand(String brand) throws DaoException {
		return null;
	}

	@Override
	public List<Product> getByCategory(String category) throws DaoException {
		return null;
	}

}
