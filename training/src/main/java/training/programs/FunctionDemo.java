package training.programs;

public class FunctionDemo {

	static void hello() {
		System.out.println("Hello");
	}

	static void welcome() {
		System.out.println("Welcome");
	}

	static void bye() {
		System.out.println("Bye!");
	}

	public static void main(String[] args) {
		// static functions can invoke only static functions
		hello();
		welcome();
		bye();
	}

}
