package training.programs;

public class Variables {

	int n;

	public static void main(String[] args) {

		System.out.println("Exploring variables of different types.");
		
		int n;

		n = 123;
		// maximum value in a n-bit variable is (2**n)-1
		// minimum value in a n-bit variable is -2**n
		
		System.out.println("Value of n in main is " + n);
		System.out.println("Value of args in main is " + args);

		n = 2147483647;
		n = Integer.MAX_VALUE;
		System.out.println("Max value of an integer is " + n);
		System.out.println("Min value of an integer is " + Integer.MIN_VALUE);
		
		System.out.println("Max value of a double variable is " + java.lang.Double.MAX_VALUE);
		System.out.println("Min value of a double variable is " + Double.MIN_VALUE);
		
		
	}
}
