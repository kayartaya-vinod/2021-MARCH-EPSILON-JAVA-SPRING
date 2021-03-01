package com.epsilon.training;

public class MathFunctions {

	public int factorial(int num) {
		int f = 1;
		for (int i = 2; i <= num; i++) {
			f *= i;
		}
		return f;
	}

}
