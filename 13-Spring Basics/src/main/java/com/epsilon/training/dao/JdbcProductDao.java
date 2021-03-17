package com.epsilon.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("dao") // @Component @Service @Repository @Controller @RestController @Configuration
public class JdbcProductDao implements ProductDao {

	// dependencies of this class/object
	private String url;
	private String username;
	private String password;
	private String driverClassName;

	@Autowired(required = false)
	private DataSource dataSource; // we have defined a bean of BasicDataSource in our context.xml

	public JdbcProductDao() {
		log.debug("Creating an instanceof JdbcProductDao class using no-arg constructor");
	}

	public JdbcProductDao(String url, String username, String password, String driverClassName) {
		log.debug("Creating an instanceof JdbcProductDao class using overloaded constructor");
		this.url = url;
		this.username = username;
		this.password = password;
		this.driverClassName = driverClassName;
	}

	// can also be used for wiring
	public JdbcProductDao(DataSource dataSource) {
		log.debug("Inside JdbcProductDao constructor, got an object of {} as argument",
				dataSource.getClass().getName());
		this.dataSource = dataSource;
	}

	// setters are also called as: Mutators/Writable properties
	// For example, this function is a writable property called "url"
	// Spring invokes this function, while INJECTING a value for the property "url"
	public void setUrl(String url) {
		log.debug("invoking setUrl function with parameter {}", url);
		this.url = url;
	}

	public void setUsername(String username) {
		log.debug("invoking setUsername function with parameter {}", username);
		this.username = username;
	}

	public void setPassword(String password) {
		log.debug("invoking setPassword function with parameter {}", password);
		this.password = password;
	}

	public void setDriverClassName(String driverClassName) {
		log.debug("invoking setDriverClassName function with parameter {}", driverClassName);
		this.driverClassName = driverClassName;
	}

	// spring can inject a bean from the container (wiring)
	// this function is a writable property called as "dataSource"
	public void setDataSource(DataSource dataSource) {
		log.debug("inside JdbcProductDao.setDataSource, dataSource is an instanceof {} class",
				dataSource.getClass().getName());
		this.dataSource = dataSource;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {

		// check if dataSource is not null, then return a connection from the same
		if (this.dataSource != null) {
			return this.dataSource.getConnection();
		}

		// this method makes use of the dependencies
		Class.forName(this.driverClassName);
		return DriverManager.getConnection(url, username, password);
	}

	@Override
	public long count() {
		String sql = "select count(*) as cnt from products";
		try (Connection conn = this.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {

			rs.next();
			return rs.getLong("cnt");
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
