package com.epsilon.training.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.epsilon.training.dao.JdbcProductDao;
import com.epsilon.training.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@PropertySource("classpath:jdbc-info.properties")
public class AppConfig3 {
	// dependency injection by Spring
	@Value("${jdbc.connection.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.connection.url}")
	private String url;
	@Value("${jdbc.connection.username}")
	private String username;
	@Value("${jdbc.connection.password}")
	private String password;

	// This method is automatically called by Spring during the container creation,
	// and collects the return value from this function, and registers it as a bean
	// with either the name of the function or the name specified in @Bean.
	// If the function defines one or more parameters, then Spring attempts to
	// inject a suitable bean (if available).
	@Bean // (autowire = Autowire.BY_NAME)
	public ProductDao dao(DataSource dataSource) { // dependency injection
		log.debug("In AppConfig3.dao function, ds is an instanceof {}", dataSource.getClass().getName());
		return new JdbcProductDao(dataSource); // manual wiring using constructor
	}

	@Bean
	public DataSource dataSource() {
		log.debug("Inside AppConfig3.dataSource() function");
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
