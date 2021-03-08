package com.epsilon.training.programs;

import com.epsilon.training.entity.Point;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatePoints {

	public static void main(String[] args) {
		
		Point<Integer> p1;
		p1 = new Point<>();
		p1.setX(12);
		p1.setY(22);
		log.debug("p1 is {}", p1);
		
		Point<Double> p2 = new Point<>(12.34, 56.78);
		log.debug("p2 is {}", p2);
		
		Point<String> p3 = new Point<>();
		p3.setX("23");
		p3.setY("45");
		log.debug("p3 is {}", p3);
		
		
	}
}
