package com.epsilon.training.entity;

public class InvalidIdException extends Exception {

	private static final long serialVersionUID = -5564317165017710558L;

	public InvalidIdException() {
		super();
	}

	public InvalidIdException(String message) {
		super(message);
	}

	public InvalidIdException(Throwable cause) {
		super(cause);
	}

}
