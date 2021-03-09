package com.epsilon.training.dao;

import java.util.Arrays;
import java.util.List;

import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayProductDao implements ProductDao {

	Product[] products;
	int index = 0;
	static final int MAX_PRODUCTS = 100;

	public ArrayProductDao() {
		log.debug("ArrayProductDao instantiated");
		this.products = new Product[MAX_PRODUCTS]; // this is the accepted boundary
	}

	@Override
	public void addProduct(Product product) throws DaoException {
		log.debug("ArrayProductDao.addProduct() called with {}", product);

		// TODO validate the product before proceeding further

		if (index < MAX_PRODUCTS) {
			this.products[index++] = product;
		} else {
			throw new RuntimeException("Exceeded the maximum allowed products");
		}
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
		return Arrays.asList(this.products);
	}

}
