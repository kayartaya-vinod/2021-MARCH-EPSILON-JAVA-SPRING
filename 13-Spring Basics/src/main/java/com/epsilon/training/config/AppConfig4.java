package com.epsilon.training.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.epsilon.training.dao.JdbcProductDao;
import com.epsilon.training.dao.ProductDao;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
public class AppConfig4 {
	@Value("${jdbc.connection.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.connection.url}")
	private String url;
	@Value("${jdbc.connection.username}")
	private String username;
	@Value("${jdbc.connection.password}")
	private String password;

	@Bean
	public ProductDao dao() {
		return new JdbcProductDao();
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driverClassName);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);

		bds.setMaxTotal(50);
		bds.setInitialSize(5);
		bds.setMaxWaitMillis(3000);
		bds.setMaxIdle(5);

		return bds;
	}
}
