package com.epsilon.training.utils;

import java.util.Scanner;

public final class KeyboardUtil {

	// when ever you have a class (utility) with out any member variables
	// make all functions static, class as final and
	// no-arg constructor as private

	private KeyboardUtil() {
	}

	// mark the function as static, if the function does not use
	// the members of the object
	public static int getInt(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static String getString(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public static double getDouble(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}

}
