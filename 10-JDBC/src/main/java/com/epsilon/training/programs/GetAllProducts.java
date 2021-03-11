package com.epsilon.training.programs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.epsilon.training.util.DbUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetAllProducts {

	public static void main(String[] args) {

		String sql = "select * from products";
		int rc = 0;
		try(
			Connection conn = DbUtil.createConnection();
			Statement stmt = conn.createStatement(); // no db round trip
			ResultSet rs = stmt.executeQuery(sql); // 1st and only db round trip
		){
			while(rs.next()) {
				rc++;
				String name = rs.getString("name");
				String qpu = rs.getString("quantity_per_unit");
				String brand = rs.getString("brand");
				String category = rs.getString("category");
				double price = rs.getDouble("unit_price");
				
				System.out.printf("%-20s %-40s %-10s %-10s %10.2f\n",
						name, qpu, brand, category, price);
			}
			log.debug("Total no.of rows = {}", rc);
		} // conn, stmt and rs get closed here
		catch(Exception ex) {
			log.warn("Error - {}", ex.getMessage());
		}
		
	}

}
