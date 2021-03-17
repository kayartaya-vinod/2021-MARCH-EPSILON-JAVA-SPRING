package com.epsilon.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.epsilon.training.dao.JdbcProductDao;
import com.epsilon.training.dao.ProductDao;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
public class AppConfig2 {

	// dependency injection by Spring
	@Value("${jdbc.connection.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.connection.url}")
	private String url;
	@Value("${jdbc.connection.username}")
	private String username;
	@Value("${jdbc.connection.password}")
	private String password;

	@Bean(name = { "dao", "jdbcProductDao" })
	public ProductDao jdbcDao() {
		JdbcProductDao dao = new JdbcProductDao();

		// setter injection in XML
		dao.setDriverClassName(driverClassName);
		dao.setUrl(url);
		dao.setUsername(username);
		dao.setPassword(password);

		return dao;
	}
}
