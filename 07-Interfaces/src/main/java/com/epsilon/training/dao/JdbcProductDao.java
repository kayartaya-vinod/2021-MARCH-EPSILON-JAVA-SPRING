package com.epsilon.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epsilon.training.entity.Product;
import com.epsilon.training.utils.DbUtil;

public class JdbcProductDao implements ProductDao {

	@Override
	public void addProduct(Product product) throws DaoException {
		// TODO Implement this method using JDBC
	}

	@Override
	public Product getProduct(int id) throws DaoException {
		String sql = "select * from products where id = ?";
		try (Connection conn = DbUtil.createConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					return createProduct(rs);
				}
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return null;
	}

	private Product createProduct(ResultSet rs) throws SQLException {
		Product p = new Product();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setBrand(rs.getString("brand"));
		p.setCategory(rs.getString("category"));
		p.setDescription(rs.getString("description"));
		p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
		p.setPicture(rs.getString("picture"));
		p.setDiscount(rs.getDouble("discount"));
		p.setUnitPrice(rs.getDouble("unit_price"));
		return p;
	}

	@Override
	public void updateProduct(Product p) throws DaoException {
		// TODO Implement this method using JDBC
		// update products set name=?, brand=?,..... where id=?
		
		String sql = "update products set name=?, brand=?, category=?, description=?, quantity_per_unit=?,"
				+ " picture=?, unit_price=?, discount=? where id=?";
		
		try(Connection conn = DbUtil.createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setString(1, p.getName());
			// ...
			stmt.setDouble(7, p.getUnitPrice());
			stmt.setDouble(8, p.getDiscount());
			stmt.setInt(9, p.getId());
			
		}
		catch(Exception ex) {
			throw new DaoException(ex);
		}
		
	}

	@Override
	public void deleteProduct(int id) throws DaoException {
		// TODO Implement this method using JDBC
	}

	@Override
	public List<Product> getAll() throws DaoException {
		return null;
	}

	@Override
	public List<Product> getByPriceRange(double min, double max) throws DaoException {
		return null;
	}

	@Override
	public List<Product> getByBrand(String brand) throws DaoException {
		return null;
	}

	@Override
	public List<Product> getByCategory(String category) throws DaoException {
		return null;
	}

}
