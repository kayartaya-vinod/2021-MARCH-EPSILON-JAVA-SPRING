package com.epsilon.training.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epsilon.training.dao.ProductDao;
import com.epsilon.training.entity.Product;

@RestController
@RequestMapping("/api/products")
public class ProductResource {

	@Autowired
	ProductDao dao;

	@GetMapping(produces = "application/json")
	public Map<String, Object> getAllProducts() {
		Map<String, Object> map = new HashMap<>();
		map.put("data", dao.findAll());
		map.put("count", dao.count());
		
		return map;
	}
	
	@GetMapping(produces = "application/json", path="/{id}")
	public Product getOneProduct(@PathVariable Integer id) {
		return dao.findById(id).get();
	}
	
	@GetMapping(produces = "application/json", path="/filter", params = "brand")
	public Iterable<Product> getProductsByBrand(@RequestParam String brand) {
		return dao.findByBrand(brand);
	}
	
	@GetMapping(produces = "application/json", path="/filter", params = "category")
	public Iterable<Product> getProductsByCategory(@RequestParam String category) {
		return dao.findByCategory(category);
	}
	
	@GetMapping(produces = "application/json", path="/filter", params = {"min", "max"})
	public Iterable<Product> getProductsByPriceRange(@RequestParam Double min, @RequestParam Double max) {
		return  dao.findByPriceRange(min, max);
	}
}













