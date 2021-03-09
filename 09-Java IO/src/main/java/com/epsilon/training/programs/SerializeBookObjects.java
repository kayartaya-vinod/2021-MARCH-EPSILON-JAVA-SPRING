package com.epsilon.training.programs;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.epsilon.training.entity.Book;

public class SerializeBookObjects {

	public static void main(String[] args) throws Exception{
		Book[] books = {
				new Book(1234, "Let us C", 299.0),
				new Book(2234, "C Pearls", 350.0),
				new Book(1256, "Python made easy", 499.0),
				new Book(5478, "Python cook book", 799.0)
		};
		
		try(FileOutputStream file = new FileOutputStream("books.data");
			ObjectOutputStream out = new ObjectOutputStream(file);){
			
			for(Book b: books) {
				out.writeObject(b);
			}
			System.out.println("Books written to file - books.data");
		}
	}

}
