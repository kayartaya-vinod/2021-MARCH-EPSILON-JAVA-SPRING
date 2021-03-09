package com.epsilon.training.programs;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.epsilon.training.entity.Book;
import com.epsilon.training.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsingTreeSet {

	public static void main(String[] args) {
		Set<Person> people = new TreeSet<>();

		people.add(new Person(1, "Vinod", "Kumar", 175, 84));
		people.add(new Person(12, "Vinod", "Kumar", 175, 84));
		people.add(new Person(2, "Shyam", "Sundar", 180, 78));
		people.add(new Person(1, "Ravi", "Kumar", 175, 84));
		people.add(new Person(1, "Vinod", "Rao", 175, 84));

		for (Person p : people) {
			log.debug("{}", p);
		}
//
//		Comparator<Book> cmp1 = new Comparator<Book>() {
//			@Override
//			public int compare(Book b1, Book b2) {
//				return b1.getIsbn() - b2.getIsbn();
//			}
//		};
		
		// arrow function (lambda expression/function) can be used only as a
		// substitution of the (only) abstract function in a function interface

		// Set<Book> books = new TreeSet<>((b1, b2) -> b1.getIsbn() - b2.getIsbn());
		
		// Set<Book> books = new TreeSet<>((b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice()));
		
		Set<Book> books = new TreeSet<>((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
		
		books.add(new Book(12, "Let us C", 299.0));
		books.add(new Book(33, "Java Complete Reference", 499.0));
		books.add(new Book(11, "Java Unleashed", 749.0));
		books.add(new Book(6, "Head first Node JS", 390.0));
		books.add(new Book(76, "Head first Java", 450.0));

		log.debug("Books are:...");
		for (Book b : books) {
			log.debug("{}", b);
		}
	}
}
