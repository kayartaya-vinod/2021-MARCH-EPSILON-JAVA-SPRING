package com.epsilon.training.programs.finaldemo;

abstract class Animal {
	abstract void talk();
}

class Cat extends Animal {
	void talk() {
		System.out.println("Meow meow...");
	}

	// final functions cannot be overridden
	final void furr() {
		System.out.println("cat furring...");
	}
}

// final classes can not be extended to other classes
final class Tiger extends Cat {
	void talk() {
		System.out.println("Tiger roaring...");
	}

	// final class cannot be inherited, and hence the methods in such class cannot
	// be overridden. therefore, final functions in final class is useless.
	final void fn() {
	}
}

public class FinalDemo {
	public static void main(String[] args) {
		
		// final variables can be assigned only once.
		final Animal a1;
		
		a1 = new Tiger();
		a1.talk();
		
		// a1 = new Cat();
	}
}
