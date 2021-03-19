package com.epsilon.training.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.epsilon.training.entity.Product;

public interface ProductDao {
	// CRUD OPERATIONS
	
	@Transactional(readOnly = false, rollbackFor = DaoException.class)
	public default void create(Product product) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

	public default Product findById(int id) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

	@Transactional(readOnly = false, rollbackFor = DaoException.class)
	public default void update(Product product) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

	@Transactional(readOnly = false, rollbackFor = DaoException.class)
	public default void delete(int id) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

	// QUERIES - TBD

	public default List<Product> findAll() throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

	public default List<Product> findByPriceRange(double min, double max) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

	public default List<Product> findByBrand(String brand) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

	public default List<Product> findByCategory(String category) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

	public long count() throws DaoException;
}
