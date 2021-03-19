package com.epsilon.training.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epsilon.training.config.AppConfig5;
import com.epsilon.training.dao.DaoException;
import com.epsilon.training.dao.ProductDao;
import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestingProductDaoMethods {

	public static void main(String[] args) throws Exception {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig5.class)) {

			ProductDao dao = ctx.getBean("htDao", ProductDao.class);
			log.info("In TestingProductDaoMethods.main(), dao is an instanceof {}", dao.getClass().getName());

			long pc = dao.count();
			log.info("Product count = {}", pc);

			Product p = dao.findById(23);
			log.info("p is {}", p);

			try {
				log.info("Before updating, p.unitPrice is {}", p.getUnitPrice());
				p.setUnitPrice(p.getUnitPrice() + 1);
				dao.update(p);
				p = dao.findById(23);
				log.info("After updating, p.unitPrice is {}", p.getUnitPrice());
			} catch (DaoException e) {
				log.warn("There was an error while updating the product price - {}", e.getMessage());
			}

			List<Product> list = dao.findAll();
			log.info("list.size() = {}", list.size());

			list = dao.findByPriceRange(10, 20);
			log.info("There are {} products between Rs.10 and Rs.20", list.size());

			list = dao.findByPriceRange(20, 10);
			log.info("There are {} products between Rs.20 and Rs.10", list.size());

			list = dao.findByBrand("Zespri");
			log.info("There are {} Zespri products", list.size());

			list = dao.findByCategory("fruit");
			log.info("There are {} fruits", list.size());

		}

	}

}
