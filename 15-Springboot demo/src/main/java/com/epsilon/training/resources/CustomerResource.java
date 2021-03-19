package com.epsilon.training.resources;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epsilon.training.dao.CustomerDao;
import com.epsilon.training.entity.Customer;

@RestController
@RequestMapping(path = "/api/customers", produces = "application/json")
public class CustomerResource {

	@Autowired
	CustomerDao dao;

	@GetMapping
	public Iterable<Customer> getAll(@RequestParam(name = "_page", required = false, defaultValue = "1") Integer page,
			@RequestParam(name = "_limit", required = false, defaultValue = "10") Integer limit) {

		return dao.findAll(PageRequest.of(page - 1, limit));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		Optional<Customer> op = dao.findById(id);
		if (op.isPresent()) {
			return ResponseEntity.ok(op.get());
		}

		Map<String, Object> map = new HashMap<>();
		map.put("message", "No data found for id " + id);
		map.put("timestamp", new Date());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

	@GetMapping(path = "/search", params = "email")
	public ResponseEntity<?> getByEmail(@RequestParam String email) {
		Optional<Customer> op = dao.findByEmail(email);
		if (op.isPresent()) {
			return ResponseEntity.ok(op.get());
		}

		Map<String, Object> map = new HashMap<>();
		map.put("message", "No data found for email " + email);
		map.put("timestamp", new Date());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

	@GetMapping(path = "/search", params = "phone")
	public ResponseEntity<?> getByPhone(@RequestParam String phone) {
		Optional<Customer> op = dao.findByPhone(phone);
		if (op.isPresent()) {
			return ResponseEntity.ok(op.get());
		}

		Map<String, Object> map = new HashMap<>();
		map.put("message", "No data found for phone " + phone);
		map.put("timestamp", new Date());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

	@GetMapping(path = "/search", params = "city")
	public Iterable<Customer> getByCity(@RequestParam String city) {
		return dao.findByCity(city);
	}

	@GetMapping(path = "/search", params = "state")
	public Iterable<Customer> getByState(@RequestParam String state) {
		return dao.findByState(state);
	}
	
	@PostMapping(consumes = "application/json")
	public Customer addNewCustomer(@RequestBody Customer customer) {
		customer.setId(null);
		return dao.save(customer);
	}
	
	@PutMapping(path = "/{id}", consumes = "application/json")
	public ResponseEntity<?> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		
		Optional<Customer> c = dao.findById(id);
		if(c.isPresent()) {
			customer.setId(id);
			customer = dao.save(customer);
			return ResponseEntity.ok(customer);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("\"No data found for id " + id + "\"");
	}

}














