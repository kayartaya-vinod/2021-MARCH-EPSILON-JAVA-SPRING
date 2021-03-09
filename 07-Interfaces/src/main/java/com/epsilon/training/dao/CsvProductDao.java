package com.epsilon.training.dao;

import java.util.List;

import com.epsilon.training.entity.Product;

public class CsvProductDao implements ProductDao {

	@Override
	public void addProduct(Product product) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Product getProduct(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int id) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getAll() throws DaoException {
		// TODO Auto-generated method stub
		return ProductDao.super.getAll();
	}

	@Override
	public List<Product> getByPriceRange(double min, double max) throws DaoException {
		// TODO Auto-generated method stub
		return ProductDao.super.getByPriceRange(min, max);
	}

	@Override
	public List<Product> getByBrand(String brand) throws DaoException {
		// TODO Auto-generated method stub
		return ProductDao.super.getByBrand(brand);
	}

	@Override
	public List<Product> getByCategory(String category) throws DaoException {
		// TODO Auto-generated method stub
		return ProductDao.super.getByCategory(category);
	}

}
