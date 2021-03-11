package com.epsilon.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.epsilon.training.util.DbUtil;
import com.epsilon.training.util.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetProductById {

	public static void main(String[] args) {

		int id = KeyboardUtil.getInt("Enter id to search: ");

		String sql = "select * from products where id = ?";

		try (Connection conn = DbUtil.createConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, id);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					System.out.println("Name    : " + rs.getString("name"));
					System.out.println("QPU     : " + rs.getString("quantity_per_unit"));
					System.out.println("Brand   : " + rs.getString("brand"));
					System.out.println("Category: " + rs.getString("category"));
					System.out.println("Price   : Rs." + rs.getDouble("unit_price"));
					System.out.println("Picture : " + rs.getString("picture"));
				} else {
					System.out.println("No data found for id " + id);
				}
			} // rs is closed

		} // conn, stmt are closed
		catch (Exception ex) {
			log.warn("Error - {}", ex);
		}
	}
}
