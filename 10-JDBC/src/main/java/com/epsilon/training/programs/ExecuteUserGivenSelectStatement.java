package com.epsilon.training.programs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.epsilon.training.util.DbUtil;
import com.epsilon.training.util.KeyboardUtil;

public class ExecuteUserGivenSelectStatement {

	public static void main(String[] args) {

		String sql = KeyboardUtil.getString("Enter sql SELECT command: ");
		
		try(Connection conn = DbUtil.createConnection();
			Statement stmt =conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);){
			
			ResultSetMetaData meta = rs.getMetaData();
			String tname = meta.getTableName(1);
			
			System.out.println("Here is the data from the table " + tname + " corresponding to your query: ");
			int cc = meta.getColumnCount();
			
			for(int i=1; i<=cc; i++) {
				System.out.print(meta.getColumnName(i) + ", ");
			}
			System.out.println();
			
			while(rs.next()) {
				
				for(int i=1; i<=cc; i++) {
					System.out.print(rs.getString(i) + ", ");
				}
				System.out.println();
			}
			
		}
		catch(Exception ex) {
			System.err.println("There was an error - " + ex.getMessage());
			
		}
	}

}
