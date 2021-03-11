package com.epsilon.training.programs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epsilon.training.entity.Product;

public class GetProductById {

	public static void main(String[] args) {

		// "epsilon" is a named persistence unit in META-INF/persistence.xml found
		// in the CLASSPATH (or build path)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("epsilon");
		System.out.println("Got EntityManagerFactory of type: " + emf.getClass().getName());
		
		EntityManager em = emf.createEntityManager();
		System.out.println("Got EntityManager of type: " + em.getClass().getName());
		
		
		Product p = em.find(Product.class, 34);
		System.out.println(p);
		
		em.close();
		emf.close();
		
	}

}
