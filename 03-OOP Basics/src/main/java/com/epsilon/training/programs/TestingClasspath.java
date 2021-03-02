package com.epsilon.training.programs;

import lombok.extern.slf4j.Slf4j;
import training.utils.KeyboardUtil;

@Slf4j
public class TestingClasspath {
	
	public static void main(String[] args) {
		log.info("start of main");
		
		String name = KeyboardUtil.getString("Enter your name: ");
		System.out.println("Hello, " +  name + "!");
		
		log.info("end of main");
	}
}
