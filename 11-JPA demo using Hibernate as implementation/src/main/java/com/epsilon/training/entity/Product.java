package com.epsilon.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {
	@Id
	private int id;
	private String name;
	private String description;
	private String brand;
	private String category;
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	@Column(name="unit_price")
	private double unitPrice;
	private double discount;
	private String picture;
}
