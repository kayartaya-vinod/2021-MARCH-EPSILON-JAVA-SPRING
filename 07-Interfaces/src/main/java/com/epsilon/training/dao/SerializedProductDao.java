package com.epsilon.training.dao;

import java.util.List;

import com.epsilon.training.entity.Product;

public class SerializedProductDao implements ProductDao {
	
	// for performance, keep all products in a map, and 
	// serialize/deserialize when required.

	@Override
	public void addProduct(Product product) throws DaoException {

	}

	@Override
	public Product getProduct(int id) throws DaoException {
		return null;
	}

	@Override
	public void updateProduct(Product product) throws DaoException {

	}

	@Override
	public void deleteProduct(int id) throws DaoException {

	}

	@Override
	public List<Product> getAll() throws DaoException {
		return ProductDao.super.getAll();
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
