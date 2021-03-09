package com.epsilon.training.dao;

import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyProductDao implements ProductDao {

	@Override
	public void addProduct(Product product) throws DaoException {
		try {
			log.debug("DummyProductDao.addProduct() called");
		} catch (Exception ex) {
			throw new DaoException(ex); // exception funneling; decorator pattern
		}
	}

	@Override
	public Product getProduct(int id) throws DaoException {
		log.debug("Retrieving a product");
		return null;
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		log.debug("Updating a product");
	}

	@Override
	public void deleteProduct(int id) throws DaoException {
		log.debug("Deleting a product");
	}

}
