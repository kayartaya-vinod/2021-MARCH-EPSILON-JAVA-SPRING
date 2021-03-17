package com.epsilon.training.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epsilon.training.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetProductCount {

	public static void main(String[] args) throws Exception {
		// Variable representing Spring container
		ClassPathXmlApplicationContext ctx;
		
		// A Spring container based on an XML file (context.xml) in the CLASSPATH
		ctx = new ClassPathXmlApplicationContext("context.xml");
		
		ProductDao dao = ctx.getBean("jdbc", ProductDao.class);
		long pc = dao.count();
		log.debug("[using jdbc] There are {} products", pc);
		
		dao = ctx.getBean("dummy", ProductDao.class);
		pc = dao.count();
		log.debug("There are {} products", pc);
		
		ProductDao dao1 = ctx.getBean("dummy", ProductDao.class);
		pc = dao.count();
		log.debug("[using dummy] There are {} products", pc);
		log.debug("dao == dao1 is {}", dao==dao1);
		
		
		dao1 = ctx.getBean("dao1", ProductDao.class);
		pc = dao1.count();
		log.debug("[using dao1] There are {} products", pc);
		

		dao1 = ctx.getBean("dao2", ProductDao.class);
		pc = dao1.count();
		log.debug("[using dao2] There are {} products", pc);

		ctx.close();
	}

}
