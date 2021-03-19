package com.epsilon.training.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("htDao") // qualifies for component-scan
@SuppressWarnings({ "unchecked", "deprecation" })
public class HibernateTemplateProductDao implements ProductDao {

	// dependency
	@Autowired
	private HibernateTemplate template;

	public HibernateTemplateProductDao() {
		log.info("Inside HibernateTemplateProductDao() template is {}", template);
	}

	@PostConstruct
	public void init() {
		log.info("Inside HibernateTemplateProductDao.init() template is {}", template);
	}

	@Override
	public void create(Product product) throws DaoException {
		template.persist(product);
	}

	@Override
	public Product findById(int id) throws DaoException {
		return template.get(Product.class, id);
	}

	@Override
	public void update(Product product) throws DaoException {
		// log the method entry
		// check for security credentials
		// begin transaction
		template.merge(product);
		// commit or roll back transaction
		// log the method exit
	}

	@Override
	public void delete(int id) throws DaoException {
		Product p = this.findById(id);
		if (p == null) {
			throw new DaoException("No data found for the given id: " + id);
		}
		template.delete(p);
	}

	@Override
	public List<Product> findAll() throws DaoException {
		return (List<Product>) template.find("from Product");
	}

	@Override
	public List<Product> findByPriceRange(double min, double max) throws DaoException {
		return (List<Product>) template.find("from Product where unitPrice between ?0 and ?1", min, max);
	}

	@Override
	public List<Product> findByBrand(String brand) throws DaoException {
		return (List<Product>) template.find("from Product where brand = ?0", brand);
	}

	@Override
	public List<Product> findByCategory(String category) throws DaoException {
		return (List<Product>) template.find("from Product where category = ?0", category);
	}

	@Override
	public long count() throws DaoException {
		return Long.valueOf(template.find("select count(p) from Product p").get(0).toString());
	}

}
