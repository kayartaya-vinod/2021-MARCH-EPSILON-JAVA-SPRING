package com.epsilon.training.entity;

public class InvalidNameException extends Exception {

	private static final long serialVersionUID = -1397315729730869853L;

	public InvalidNameException() {
	}

	public InvalidNameException(String message) {
		super(message);
	}

	public InvalidNameException(Throwable cause) {
		super(cause);
	}

}
