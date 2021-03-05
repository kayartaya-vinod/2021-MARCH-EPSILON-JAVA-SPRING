package com.epsilon.training.entity;

import lombok.Data;

@Data
public class Product {
	private int id;
	private String name;
	private String description;
	private String brand;
	private String category;
	private String quantityPerUnit;
	private double unitPrice;
	private double discount;
	private String picture;
}
