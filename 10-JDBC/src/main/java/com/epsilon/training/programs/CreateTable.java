package com.epsilon.training.programs;

import java.sql.Connection;
import java.sql.Statement;

import com.epsilon.training.util.DbUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateTable {

	public static void main(String[] args) {
		
		String sqlCmd = "create table products(\n"
				+ "    id int primary key auto_increment,\n"
				+ "    name varchar(50) not null,\n"
				+ "    brand varchar(50) not null,\n"
				+ "    category varchar(50) not null,\n"
				+ "    quantity_per_unit varchar(255) not null,\n"
				+ "    description varchar(255) not null,\n"
				+ "    picture varchar(255) not null,\n"
				+ "    unit_price double,\n"
				+ "    discount double\n"
				+ ");\n"
				+ "";

		try (Connection conn = DbUtil.createConnection();
			Statement stmt = conn.createStatement();) {
			
			stmt.execute(sqlCmd);
			log.debug("SQL Commmand executed successfully!");
			
		} catch (Exception e) {
			log.warn("There was an error: {}", e.getMessage());
		}

	}

}
