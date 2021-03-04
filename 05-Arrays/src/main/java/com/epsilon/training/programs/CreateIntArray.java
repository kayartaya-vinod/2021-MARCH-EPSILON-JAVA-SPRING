package com.epsilon.training.programs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateIntArray {

	static Logger log = LoggerFactory.getLogger(CreateIntArray.class);

	public static void main(String[] args) {

		int nums[] = { 12, 39, 49 };
		log.debug("nums is {}", nums);
		log.debug("nums has {} elements", nums.length);
		log.debug("nums is an instance of class {}", nums.getClass().getName());

		nums = new int[] { 100, 200, 12, 20 };
		log.debug("nums is {}", nums);
		log.debug("nums has {} elements", nums.length);
		
		for (int i = 0; i < nums.length; i++) {
			log.debug("nums[{}] = {}", i, nums[i]);
		}
		
		// read as :: for each num in nums
		for (int num : nums) {
			log.debug("num is {}", num);
		}
		
		nums = new int[2];
		nums[0] = 123;
		nums[1] = 456;		
		log.debug("nums is {}", nums);
		log.debug("nums has {} elements", nums.length);

		
	}

}
