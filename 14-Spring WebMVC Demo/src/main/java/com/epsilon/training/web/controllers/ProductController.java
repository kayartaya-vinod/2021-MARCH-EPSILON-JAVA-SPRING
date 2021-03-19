package com.epsilon.training.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epsilon.training.dao.DaoException;
import com.epsilon.training.dao.ProductDao;
import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller // qualifies for component-scan; also, treated as a special call by MVC
			// components
public class ProductController {

	@Autowired
	private ProductDao dao;

	public ProductController() {
		log.debug("ProductController instantiated!");
	}

	// request handler method
	@RequestMapping("/product-list")
	public String getAllProducts(Model model) throws DaoException {
		// store the model data in a common scope (place)
		model.addAttribute("products", dao.findAll());

		return "/show-products.jsp";
	}

	// http://localhost:8080/training/products-by-brand?brand=Malnad
	@RequestMapping("/products-by-brand")
	public String getProductsByBrand(@RequestParam("brand") String brand, Model model) throws DaoException {
		model.addAttribute("products", dao.findByBrand(brand));
		return "/show-products.jsp";
	}

	// http://localhost:8080/training/products-by-category?category=Malnad
	@RequestMapping("/products-by-category")
	public String getProductsByCategory(@RequestParam("category") String category, Model model) throws DaoException {
		model.addAttribute("products", dao.findByCategory(category));
		return "/show-products.jsp";
	}

	@RequestMapping("/product-details")
	public ModelAndView getProductById(@RequestParam int id) throws DaoException {
		return new ModelAndView("/product-details.jsp", "p", dao.findById(id));
	}
	
	@RequestMapping("/delete-product")
	public String deleteProduct(@RequestParam int id) throws DaoException {
		dao.delete(id);
		return "redirect:product-list";
	}

	@RequestMapping("/edit-product")
	public ModelAndView editProduct(@RequestParam int id) throws DaoException {
		return new ModelAndView("/product-form.jsp", "p", dao.findById(id));
	}
	
	@RequestMapping("/update-product")
	public String updateProduct(@ModelAttribute Product product) throws DaoException {
		dao.update(product);
		return "redirect:product-details?id=" + product.getId();
	}
}
