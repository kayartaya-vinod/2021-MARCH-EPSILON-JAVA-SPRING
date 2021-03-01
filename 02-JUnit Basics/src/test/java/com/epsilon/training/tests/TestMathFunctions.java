package com.epsilon.training.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.epsilon.training.MathFunctions;

public class TestMathFunctions {

	MathFunctions mf;

	@BeforeEach
	void setup() {
		System.out.println("Executing setup()...");
		mf = new MathFunctions();
	}

	@AfterEach
	void tearDown() {
		System.out.println("Executing tearDown()...\n");
	}

	@BeforeAll
	static void init() {
		System.out.println("Executing init()...\n");
	}

	@AfterAll
	static void destroy() {
		System.out.println("Executing destroy()...");
	}

	@Test
	void testFactorialOf5() {
		System.out.println("Executing testFactorialOf5()...");
		mf = new MathFunctions();
		int actual = mf.factorial(5);
		int expected = 120;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testFactorialOfNegative() {
		System.out.println("Executing testFactorialOfNegative()...");
		int actual = mf.factorial(-10);
		int expected = 1;
		Assertions.assertEquals(expected, actual);
	}

	@Disabled
	@Test
	void dummy() {
		System.out.println("Executing dummy()...");
	}
}
