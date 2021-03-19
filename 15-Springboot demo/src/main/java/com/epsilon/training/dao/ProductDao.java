package com.epsilon.training.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epsilon.training.entity.Product;

public interface ProductDao extends CrudRepository<Product, Integer> {

	// custom finder functions
	// Spring expects findByXxx where Xxx is the property in the entity class
	// For example: findByBrand, findByCategory

	public Iterable<Product> findByBrand(String brand);

	public Iterable<Product> findByCategory(String category);

	// When a JPQL is specified using @Query, the name of the function is not
	// significant to Spring boot
	@Query("from Product where unitPrice between ?1 and ?2")
	public Iterable<Product> findByPriceRange(Double min, Double max);
}
