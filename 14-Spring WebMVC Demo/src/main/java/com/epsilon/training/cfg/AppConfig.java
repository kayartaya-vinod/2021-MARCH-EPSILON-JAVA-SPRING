package com.epsilon.training.cfg;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@PropertySource("classpath:jdbc-info.properties")
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.epsilon.training.web", "com.epsilon.training.dao", "com.epsilon.training.aop" })
public class AppConfig  implements WebApplicationInitializer, WebMvcConfigurer {

	public AppConfig() {
		log.debug("AppConfig instantiated!");
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// the parameter "servletContext" represents the web server (tomcat)
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		log.debug("AppConfig.onStartup() called");
		// we are creating a new spring container (which we did in our main program in
		// the past),
		// and register this AppConfig with the container
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);

		// create the front-controller to receive all incoming requests, that will be
		// dispatched to appropriate handler methods of controllers
		
		Dynamic ds = servletContext.addServlet("ds", new DispatcherServlet(ctx));
		ds.addMapping("/");
		ds.setLoadOnStartup(1);
	}
	
	@Value("${jdbc.connection.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.connection.url}")
	private String url;
	@Value("${jdbc.connection.username}")
	private String username;
	@Value("${jdbc.connection.password}")
	private String password;
	
	// create bean of appropriate TransactionManager
	@Bean
	public HibernateTransactionManager txMgr(SessionFactory sf) {
		return new HibernateTransactionManager(sf);
	}

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
