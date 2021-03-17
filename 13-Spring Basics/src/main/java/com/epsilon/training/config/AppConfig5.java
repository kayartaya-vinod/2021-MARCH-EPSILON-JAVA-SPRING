package com.epsilon.training.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.epsilon.training.entity.Product;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
@ComponentScan(basePackages = { "com.epsilon.training.dao" })
public class AppConfig5 {
	@Value("${jdbc.connection.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.connection.url}")
	private String url;
	@Value("${jdbc.connection.username}")
	private String username;
	@Value("${jdbc.connection.password}")
	private String password;

	// this represents an object of SessionFactory
	// A session factory represents a Database and Entity classes, which can be
	// used for manufacturing session objects. session object provides CRUD
	// operations
	// and methods for querying database
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) { // dependency injection
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();

		lsfb.setDataSource(dataSource); // manual wiring via setter
		lsfb.setAnnotatedClasses(Product.class); // list of all entity classes this should manage

		return lsfb;
	}

	// this depends on an object of SessionFactory
	@Bean
	public HibernateTemplate template(SessionFactory sessionFactory) { // dependency injection
		return new HibernateTemplate(sessionFactory); // manual wiring via constructor
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
