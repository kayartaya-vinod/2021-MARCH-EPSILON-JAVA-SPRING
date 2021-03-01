package training.programs;

import training.utils.KeyboardUtil;

// Pascal casing --> class, interface, enum, annotation
// camel casing --> variables, functions
// lower case --> keywords, package names
// capital letters --> variables with abbreviations, constants
public class PrimesDemo {

	static boolean isPrime(int num) {
		for (int i = 2, lim = num / 2; i <= lim; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int start = KeyboardUtil.getInt("Enter starting number: ");
		int end = KeyboardUtil.getInt("Enter ending number: ");

		System.out.printf("List of primes between %d and %d: \n", start, end);
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				System.out.print(i + ", ");
			}
		}
		System.out.println();
	}
}
