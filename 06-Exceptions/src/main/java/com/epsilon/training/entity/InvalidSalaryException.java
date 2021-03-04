package com.epsilon.training.entity;

public class InvalidSalaryException extends Exception {

	private static final long serialVersionUID = 6754026301558254915L;

	public InvalidSalaryException() {
	}

	public InvalidSalaryException(String message) {
		super(message);
	}

	public InvalidSalaryException(Throwable cause) {
		super(cause);
	}

}
