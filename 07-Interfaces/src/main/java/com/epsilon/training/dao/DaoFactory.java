package com.epsilon.training.dao;

public final class DaoFactory {

	private static final String discriminator = "ARRAY";

	private DaoFactory() {
	}

	public static ProductDao getProductDao() {
		switch (discriminator.toUpperCase()) {
		case "DUMMY":
			return new DummyProductDao();
		case "ARRAY":
			return new ArrayProductDao();
		case "JDBC":
		case "MONGODB":
		case "CSV":
			throw new RuntimeException("Requested implementation of ProductDao not available yet.");
		default:
			throw new RuntimeException("Invalid discriminator");
		}
	}
}
