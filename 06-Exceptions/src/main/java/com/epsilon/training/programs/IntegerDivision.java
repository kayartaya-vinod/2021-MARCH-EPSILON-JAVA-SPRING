package com.epsilon.training.programs;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegerDivision {

	public static void main(String[] args) {
		log.debug("start of main");

		log.debug("program received {} arguments", args.length);
		for (int i = 0; i < args.length; i++) {
			log.debug("args[{}] = {} of type {}", i, args[i], args[i].getClass().getName());
		}

		try {
			String input1 = args[0];
			String input2 = args[1];

			int num = Integer.parseInt(input1); // "1000"
			int den = Integer.parseInt(input2); // "ten"

			int quot = num / den;

			log.debug("{} / {} = {}", num, den, quot);
		} catch (ArithmeticException e) {
			log.warn("Cannot divide by zero!");
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			log.warn("Expected 2 integers, but got {}", Arrays.toString(args));
		} catch(Exception e) {
			log.warn("An unknown error took place - {}", e.getMessage());
		}

		log.debug("end of main");
	}

	public static void main2(String[] args) {
		log.debug("start of main");

		log.debug("program received {} arguments", args.length);
		for (int i = 0; i < args.length; i++) {
			log.debug("args[{}] = {} of type {}", i, args[i], args[i].getClass().getName());
		}

		try {
			String input1 = args[0];
			String input2 = args[1];

			int num = Integer.parseInt(input1); // "1000"
			int den = Integer.parseInt(input2); // "ten"

			int quot = num / den;

			log.debug("{} / {} = {}", num, den, quot);
		} catch (NumberFormatException e) {
			log.warn("Only integers are allowed!");
		} catch (ArithmeticException e) {
			log.warn("Cannot divide by zero!");
		} catch (ArrayIndexOutOfBoundsException e) {
			log.warn("Expected 2 integers, but got {}", args.length);
		}

		log.debug("end of main");
	}

	public static void main1(String[] args) {
		log.debug("start of main");

		log.debug("program received {} arguments", args.length);
		for (int i = 0; i < args.length; i++) {
			log.debug("args[{}] = {} of type {}", i, args[i], args[i].getClass().getName());
		}

		try {
			String input1 = args[0];
			String input2 = args[1];

			int num = Integer.parseInt(input1); // "1000"
			int den = Integer.parseInt(input2); // "ten"

			int quot = num / den;

			log.debug("{} / {} = {}", num, den, quot);
		} catch (Exception e) {
			log.warn("There was an error while executing the code: {} - {}", e.getClass().getName(), e.getMessage());
		}

		log.debug("end of main");
	}

}
