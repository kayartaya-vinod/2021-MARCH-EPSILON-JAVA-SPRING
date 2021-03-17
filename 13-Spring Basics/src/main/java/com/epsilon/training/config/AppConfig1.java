package com.epsilon.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epsilon.training.dao.DummyProductDao;
import com.epsilon.training.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

// This is a substitution for context.xml.
// Just like context.xml, we configure bean definitions here (using annotations)

@Slf4j
@Configuration // <beans ... > ... </beans>
public class AppConfig1 {
	
	public AppConfig1() {
		log.debug("AppConfig1 instantiated!");
	}

	// to represent a bean, create a function which returns the bean, and annotate
	// the function with @Bean
	@Bean // equivalent of <bean name="dummy" class="...">..</bean>
	@Scope("prototype")
	public ProductDao dummy() {
		log.debug("AppConfig1.dummy() called");
		return new DummyProductDao();
	}
}
