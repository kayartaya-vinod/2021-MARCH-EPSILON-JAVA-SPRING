package com.epsilon.training.programs;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.epsilon.training.entity.Book;

public class ReadSerializedData {

	public static void main(String[] args) throws Exception {

		try (FileInputStream file = new FileInputStream("books.data");
				ObjectInputStream in = new ObjectInputStream(file);) {

			while (true) {
				try {
					Object obj = in.readObject();
					if (obj instanceof Book) {
						Book b = (Book) obj;
						System.out.println(b);
					}
				} catch (EOFException e) {
					break;
				}
			}

		}

	}

}
