package com.epsilon.training.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.epsilon.training.util.DbUtil;
import com.epsilon.training.util.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetProductsByPriceRange {

	public static void main(String[] args) {

		double min = KeyboardUtil.getDouble("Enter min price: ");
		double max = KeyboardUtil.getDouble("Enter max price: ");
		
		String sql = "select * from products where unit_price between ? and ? order by unit_price";
		
		try(Connection conn = DbUtil.createConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setDouble(1, min);
			stmt.setDouble(2, max);
			
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					String name = rs.getString("name");
					String qpu = rs.getString("quantity_per_unit");
					String brand = rs.getString("brand");
					String category = rs.getString("category");
					double price = rs.getDouble("unit_price");
					
					System.out.printf("%-20s %-40s %-10s %-10s %10.2f\n",
							name, qpu, brand, category, price);
				}
			} // rs is closed
			
		} // conn, stmt are closed
		catch(Exception ex) {
			log.warn("Error - {}", ex);
		}
	}
}
