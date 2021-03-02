package com.epsilon.training.programs;

import com.epsilon.training.entity.Book;

public class ConstructorDemo {

	public static void main(String[] args) {

		Book b1 = new Book();
		b1.print();
		System.out.println();
		
		Book b2 = new Book(1, "Let us C", 299.0);
		b2.print();
		System.out.println();
		
		Book b3 = new Book(2, "C Pearls", "Yeshwant Kanitkar", "BPB", 499.0);
		b3.print();
		
	}

}
