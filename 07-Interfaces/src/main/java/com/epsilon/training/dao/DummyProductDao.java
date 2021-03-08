package com.epsilon.training.dao;

import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyProductDao implements ProductDao {

	@Override
	public void addProduct(Product product) {
		log.debug("DummyProductDao.addProduct() called");
	}

	@Override
	public Product getProduct(int id) {
		log.debug("Retrieving a product");
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		log.debug("Updating a product");
	}

	@Override
	public void deleteProduct(int id) {
		log.debug("Deleting a product");
	}

}
