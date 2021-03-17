package com.epsilon.training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epsilon.training.config.AppConfig5;
import com.epsilon.training.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisplayProductCount {

	public static void main(String[] args) throws Exception {
		// spring container
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig5.class);

		ProductDao dao = ctx.getBean("htDao", ProductDao.class);
		log.info("Inside DisplayProductCount.main(), dao is an instanceof {}", 
				dao.getClass().getName());

		long pc = dao.count();
		log.info("There are {} products", pc);
		ctx.close();

	}

}
