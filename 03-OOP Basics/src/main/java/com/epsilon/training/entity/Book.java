package com.epsilon.training.entity;

public class Book {
	private int id; // 4
	private String title; // 8
	private String author; // 8
	private String publisher; // 8
	private double price; // 8

	// about constructors:
	// 1. have same name as the class name (fully qualified name)
	// 2. no return type; not even void
	// 3. you can use the 'return' keyword to take the control away from the
	//    constructor
	// 4. not a function; user cannot call using an object reference
	// 5. a no-argument constructor (default constructor) is given by the compiler
	//    only if the class does not have any constructor
	// 6. mostly public; but can even be private
	// 7. called while object is created
	// 8. only one constructor is used for one object
	// 9. used for initializing member data during object creation
	
	// for good practice
	public Book() {
	}

	public Book(int id, String title, double price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}

	public Book(int id, String title, String author, String publisher, double price) {
		this(id, title, price); // call to another constructor
		this.author = author;
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void print() {

		// the object used to invoke this function, is assigned automatically to a
		// keyword variable called 'this'

		System.out.println("ID        : " + this.id);
		System.out.println("Title     : " + this.title);
		System.out.println("Author    : " + this.author);
		System.out.println("Publisher : " + this.publisher);
		System.out.println("Price     : Rs." + this.price);
	}
}
