package com.epsilon.training.web.resources;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epsilon.training.dao.DaoException;
import com.epsilon.training.dao.ProductDao;
import com.epsilon.training.entity.Product;
import com.epsilon.training.entity.ProductList;

/*
 * http://localhost:8080/training/api/products
 * 
 * GET / 		--> returns a representation of all products
 * GET /{id} 	--> returns a representation of the product with the given id
 * POST / 		--> creates/adds a new product to the existing resource 'products'
 * PUT /{id}	--> updates/replaces the details of the product with the given id in the existing resource
 * DELETE /{id}	--> deletes a resource with the given id
 * 
 * Client can negotiate for a specific representation of the resource using the HTTP request headers
 * Accept 		--> can be used to ask a specific representation from the server
 * Content-Type	--> can be used to inform the server that we are sending a specific representation
 * 
 */

@RequestMapping("/api/products")
@RestController
public class ProductResource {

	@Autowired
	ProductDao dao;

	@RequestMapping("/info")
	// @ResponseBody // no view-resolution required; render the return value to the
	// client as-is
	public String info() {
		return "This is a REST endpoint for Products resource";
	}

	@GetMapping(produces = "application/json")
	public List<Product> allProducts() throws DaoException {
		return dao.findAll();
	}

	@GetMapping(produces = "application/xml")
	public ProductList allProductsAsXml() throws DaoException {
		return new ProductList(dao.findAll());
	}

	@GetMapping(produces = "application/json", params = { "brand" })
	public List<Product> productsByBrand(@RequestParam String brand) throws DaoException {
		return dao.findByBrand(brand);
	}

	// @RequestMapping(method = RequestMethod.GET, path="/{id}")
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> getById(@PathVariable int id) throws DaoException {

		Product p = dao.findById(id);
		if (p == null) {
			Map<String, Object> map = new HashMap<>();
			map.put("message", "No data found for id " + id);
			map.put("timestamp", new Date().toString());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).header("AUTHOR", "Vinod Kumar Kayartaya")
					.header("AUTHOR_EMAIL", "vinod@vinod.co").body(map);
		} else {
			return ResponseEntity.ok(p);
		}

	}

	@PostMapping(consumes = { "application/xml", "application/json" }, produces = "application/json")
	public ResponseEntity<Map<String, Object>> addNew(@RequestBody Product p) throws DaoException {
		Map<String, Object> map = new HashMap<>();
		try {
			dao.create(p);
			map.put("status", "success");
			map.put("id", p.getId());
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			map.put("status", "failed");
			map.put("reason", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}

	@PatchMapping(path = "/{id}", consumes = { "application/xml", "application/json" }, produces = "application/json")
	public ResponseEntity<Map<String, Object>> partialUpdate(@PathVariable Integer id, @RequestBody Product p)
			throws DaoException {
		Map<String, Object> map = new HashMap<>();
		try {
			Product p1 = dao.findById(id);
			if (p.getName() != null) {
				p1.setName(p.getName());
			}
			if (p.getDescription() != null) {
				p1.setDescription(p.getDescription());
			}
			if (p.getBrand() != null) {
				p1.setBrand(p.getBrand());
			}
			if (p.getCategory() != null) {
				p1.setCategory(p.getCategory());
			}
			if (p.getQuantityPerUnit() != null) {
				p1.setQuantityPerUnit(p.getQuantityPerUnit());
			}
			if (p.getUnitPrice() != null) {
				p1.setUnitPrice(p.getUnitPrice());
			}
			if (p.getDiscount() != null) {
				p1.setDiscount(p.getDiscount());
			}
			if (p.getPicture() != null) {
				p1.setPicture(p.getPicture());
			}

			dao.update(p1);
			p1 = dao.findById(id);
			
			map.put("status", "success");
			map.put("data", p1);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			map.put("status", "failed");
			map.put("reason", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
}
