package com.epsilon.training.programs;

import java.sql.Connection;
import java.sql.Statement;

import com.epsilon.training.util.DbUtil;
import com.epsilon.training.util.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsertUsingStatement {

	public static void main(String[] args) {
		String sql = getInsertSqlCommand();
		
		
		log.debug("sql command is {}", sql);
		try(Connection conn = DbUtil.createConnection();
				Statement stmt = conn.createStatement();) {
			
			conn.setAutoCommit(false);
			stmt.execute(sql);
			conn.commit();
			
			log.debug("New row inserted successfully!");
		}catch(Exception ex) {
			log.warn("Error - {}", ex.getMessage());
		}
	}

	public static String getInsertSqlCommand() {
		System.out.println("Enter new product details: ");
		String name = KeyboardUtil.getString("Name           : ");
		String brand = KeyboardUtil.getString("Brand          : ");
		String category = KeyboardUtil.getString("Category       : ");
		String quantityPerUnit = KeyboardUtil.getString("QPU            : ");
		String description = KeyboardUtil.getString("Description    : ");
		String picture = KeyboardUtil.getString("Picture        : ");
		double unitPrice = KeyboardUtil.getDouble("Unit price     : ");
		double discount = KeyboardUtil.getDouble("Discount       : ");
		
		// scope of SQL injection: https://en.wikipedia.org/wiki/SQL_injection
		String sql = String.format(
				"insert into products values(null, '%s', '%s', '%s', '%s', '%s', '%s', %f, %f)", 
				name, brand, category, quantityPerUnit, description, picture, unitPrice, discount);
		return sql;
	}

}
