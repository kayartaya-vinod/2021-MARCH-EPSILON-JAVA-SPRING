package training.programs;

import training.utils.KeyboardUtil;

public class LoopsDemo {

	public static void forLoopDemo(String[] args) {
		int num = KeyboardUtil.getInt("Enter a number: ");
		System.out.println("Table for " + num + " is:");

		// when the number of iterations is known, prefer 'for' loop
		for (int i = 1; i <= 20; i++) {
			System.out.printf("%d X %d = %d\n", num, i, num * i);
		}
	}
	
	public static void checkForPrime() {
		
		int num = KeyboardUtil.getInt("Enter a number: ");
		// 2, 3, 4, ....num-1
		// 2, 3, 4, ... num/2
		int lim = num/2;
		boolean isPrime = true;
		for(int i=2; i<lim; i++) {
			if(num%i==0) {
				isPrime = false;
				break;
			}
		}
		
		if(isPrime) {
			System.out.println(num + " is a prime number");
		}
		else {
			System.out.println(num + " is not a prime number");
		}
	}
	
	public static void main(String[] args) {
		String ans = "yes";
		while(ans.equalsIgnoreCase("yes")) {
			checkForPrime();
			ans = KeyboardUtil.getString("Do you want to try another number? yes/no: ");
		}
		System.out.println("Thank you, have a nice day!");
	}

}
