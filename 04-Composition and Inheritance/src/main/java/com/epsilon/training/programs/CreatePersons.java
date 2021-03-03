package com.epsilon.training.programs;

import com.epsilon.training.entity.Address;
import com.epsilon.training.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatePersons {
	
	public static void main(String[] args) {
		log.debug("start of main");
		
		Address addr = new Address();
		log.debug("created an Address instance");
		
		addr.setHouseNo("TF-1 Elegant Elite");
		addr.setCity("Bangalore");
		addr.setState("Karnataka");
		addr.setCountry("India");
		addr.setArea("ISRO Lyt");
		addr.setStreet("1st crs 1st mn");
		log.debug("initialized the address with values");
		
		Customer c1 = new Customer();
		log.debug("created c1 as new customer instance");
		
		c1.setId(1);
		c1.setName("Vinod");
		c1.setPhone("9731424784");
		c1.setEmail("vinod@vinod.co");
		c1.setAddress(addr);
		
		Customer c2 = new Customer();
		c2.setName("Anu");
		c2.setId(22);
		c2.setAddress(addr);
		
		c2.getAddress().setHouseNo("TF-1 (third floor)");
		
		log.info("c1 is {}", c1);
		log.info("c2 is {}", c2);
		
	}
}
