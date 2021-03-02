package com.epsilon.training.programs;

import com.epsilon.training.entity.Book;

public class CreateBookObjects {
	
	public static void main(String[] args) {
		
		Book b1;
		// b1 = null;
		b1 = new Book();
		// 1. new reserves memory required by an object of Book type in the heap
		// 2. a unique ref.number is generated (using a ref#, jre can goto the address of the object); ref# is returned
		// 3. the constructor of the object is called
		
		System.out.println("b1 is " + b1);
		
		b1.setId(123);
		b1.setTitle("Let us C");
		b1.setAuthor("Yeshwant Kanitkar");
		b1.setPublisher("BPB");
		b1.setPrice(230.0);
		
		// b1 is the invoking object; and inside the print function, it is accessible/referred as 'this'
		b1.print();
		System.out.println();
		
		Book b2 = new Book();
		b2.setId(234);
		b2.setTitle("C Pearls");
		b2.setAuthor(b1.getAuthor());
		b2.setPublisher(b1.getPublisher());
		b2.setPrice(-499.0);
		b2.print();
		
	}

}
