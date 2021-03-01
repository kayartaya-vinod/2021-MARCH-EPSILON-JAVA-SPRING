package training.programs;

import java.util.Scanner;

public class ValidMonthInput {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number for month: ");
		int mon = sc.nextInt(); // reads the next available integer value from the keyboard;
		sc.close();

		System.out.println("Your input is: " + mon);

		// the expr in if condition must be a boolean
		if (mon < 1 || mon > 12) {
			System.out.println(mon + " does not represent a valid month.");
		} else {
			System.out.println(mon + " is a valid month number.");

			switch (mon) {
			case 2:
				System.out.println("In this month, there could be 28 or 29 days.");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("In this month, there are 30 days.");
				break;
			default:
				System.out.println("In this month there are 31 days.");
			}
		}
	}
}
