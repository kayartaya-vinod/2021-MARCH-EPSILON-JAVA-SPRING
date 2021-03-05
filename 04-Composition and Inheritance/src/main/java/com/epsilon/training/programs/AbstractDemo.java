package com.epsilon.training.programs;

// abstract class can not be used for creating an object.
abstract class Animal {
	// abstract methods do not have method body
	abstract void talk(); // abstract methods may exist only in abstract class
	// primary goal of an abstract method is to force the sub classes to define a
	// valid method body for this function
}


class Bat extends Animal {

	void makeSound() {
		System.out.println("making sonic...");
	}

	@Override
	void talk() {
//		throw new RuntimeException("Bats don't talk");
		this.makeSound();
	}
}

class Tiger extends Animal {
	// overrides the inherited abstract method, so that to the compiler, the Tiger
	// class does not have any abstract methods
	void talk() {
		System.out.println("Tiger roaring...");
	}
}

class Dog extends Animal {
	void talk() {
		System.out.println("Bow bow...");
	}
}

class Cat extends Animal {
	void talk() {
		System.out.println("Meow meow...");
	}
}

class Lion extends Animal {
	void talk() {
		System.out.println("Grr....");
	}
}

public class AbstractDemo {

	public static void main(String[] args) {
		Animal[] animals = { new Lion(), new Cat(), new Dog(), new Tiger(), new Dog(), new Cat() };
		for (int i = 0; i < animals.length; i++) {
			Animal a = animals[i]; // upcasting, implicitly done (from subtype to supertype)
			System.out.println("Instance of " + a.getClass().getName());
			a.talk(); // compiler checks if "talk" is a valid function in the type of "a", which is
						// Animal
//			if (a instanceof Lion) {
//				Lion l1 = (Lion) a; // down-casting, explicitly done. May fail for incompatiable types
//				l1.talk();
//			}
		}

	}

}
