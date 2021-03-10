package com.epsilon.training.programs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.epsilon.training.util.DbUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsertCsvDataToTable {

	public static void main(String[] args) {
		String sql = "insert into products values(null, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(FileReader reader = new FileReader("products.csv");
				BufferedReader in = new BufferedReader(reader);
				Connection conn = DbUtil.createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){ // 1st DB roundtrip

			// skip header
			in.readLine();
			
			String line;
			while ((line = in.readLine()) != null) {
				String[] vals = line.split(",");
				String category = vals[0];
				String name = vals[1];
				String brand = vals[2];
				String description = vals[3];
				String quantityPerUnit = vals[4];
				double unitPrice = Double.parseDouble(vals[5]);
				String picture = vals[6];
				double discount = Double.parseDouble(vals[7]);
				
				stmt.setString(1, name);
				stmt.setString(2, brand);
				stmt.setString(3, category);
				stmt.setString(4, quantityPerUnit);
				stmt.setString(5, description);
				stmt.setString(6, picture);
				stmt.setDouble(7, unitPrice);
				stmt.setDouble(8, discount);
				
				stmt.execute(); // 2nd (multiple) DB roundtrips
				log.debug("1 ({})  record inserted successfully!", name);
			}
		}catch(Exception ex) {
			log.warn("Error - {}", ex.getMessage());
		}
	}
}
