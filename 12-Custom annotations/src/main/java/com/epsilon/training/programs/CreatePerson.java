package com.epsilon.training.programs;

import com.epsilon.training.annotations.processors.JsonSerializer;
import com.epsilon.training.entity.Person;

public class CreatePerson {

	public static void main(String[] args) {
		
		Person p1 = new Person("Vinod", "Kumar", 47, 5.8);
		p1.setWeight(84);
		System.out.println(p1);
		
		
		JsonSerializer js = new JsonSerializer();
		String json = js.serialize(p1); // serialize p1 only it has @JsonSerializable
		System.out.println(json);
		
		Person p2 = new Person("Shyam", "Sundar", 48, 6.2);
		p2.setWeight(78);
		System.out.println(js.serialize(p2));
		
		
//		String s1 = "Vinod";
//		js.serialize(s1);
		
//		p1 = null;
//		json = js.serialize(p1);
//		System.out.println(json);
		
		/*FileWriter file = new FileWriter("p1.json");
		js.serialize(file, p1);
		*/
	}
}
