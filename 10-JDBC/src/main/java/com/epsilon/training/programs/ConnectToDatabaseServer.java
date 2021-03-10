package com.epsilon.training.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabaseServer {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String driverClassName = "org.h2.Driver";
		String url = "jdbc:h2:tcp://localhost/~/epsilontraining";
		String username = "vinod";
		String password = "Welcome#123";

		// Step #1 (optional in case of most modern JDBC implementations: H2, Oracle,
		// MySQL, SQLServer)
		// Load the JDBC Driver class provided by the DB Vendor
		Class.forName(driverClassName);

		// Step #2 - Use DriverManger.getConnection (a factory method to get a
		// connection via an appropriate Driver instance). The choice of the driver is
		// based on the discriminator URL

		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("conn is an instance of " + conn.getClass());
		
		conn.close();
	}

}
