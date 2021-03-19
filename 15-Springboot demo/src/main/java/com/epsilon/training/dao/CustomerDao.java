package com.epsilon.training.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.epsilon.training.entity.Customer;

public interface CustomerDao extends PagingAndSortingRepository<Customer, Integer> {

	public Optional<Customer> findByEmail(String email);

	public Optional<Customer> findByPhone(String phone);

	public Iterable<Customer> findByCity(String city);

	public Iterable<Customer> findByState(String state);

}
