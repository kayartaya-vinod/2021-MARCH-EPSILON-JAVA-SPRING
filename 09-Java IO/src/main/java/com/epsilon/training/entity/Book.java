package com.epsilon.training.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	private int isbn;
	private String title;
	private double price;

	public void print() {

	}
}
