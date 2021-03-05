package com.epsilon.training.programs;

import com.epsilon.training.entity.Circle;
import com.epsilon.training.entity.Shape;
import com.epsilon.training.entity.Triangle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateShapes {

	static void printShapeData(Shape shape) {
		log.debug("area of the shape ({}) is {}", shape.getClass().getName(), shape.getArea());
		shape.info();
		
		if (shape instanceof Circle) {
			// down casting
			Circle c = (Circle) shape;
			log.debug("Radius of this circle is {}", c.getRadius());
		} else if (shape instanceof Triangle) {
			Triangle t = (Triangle) shape;
			log.debug("Triangle's base = {}, height = {}", t.getBase(), t.getHeight());
		}
		log.debug("-----------------");
	}

	public static void main(String[] args) {
		Circle c1 = new Circle(23.45);
		Triangle t1 = new Triangle(12.34, 45.67);

		printShapeData(c1);
		printShapeData(t1);
		
		printShapeData(new Shape() {
			@Override
			public double getArea() {
				return 22.34;
			}
		});

		printShapeData(()->345.677);

		
		Shape.details();
		Triangle.details();
	}

}

// Shape s1;
// s1 = new Shape(); // Shape is abstract; cannot be instantiated!!

// an object of an interface can be realized using an object of a class, that
// implements the interface (and it's features)
// s1 = new Circle(12.34); // <-- instanceof Circle, Shape, Object
