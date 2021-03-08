package com.epsilon.training.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.epsilon.training.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsingSets {
	static void printInfo(String varName, Set<?> set) {
		log.debug("{}  contains {} elements", varName, set.size());
		log.debug("{} = {}", varName, set);
		log.debug("");
	}

	public static void main(String[] args) {
		Set<Integer> nums = new TreeSet<>();

		nums.add(12);
		nums.add(22);
		nums.add(12);
		nums.add(22);
		nums.add(3);
		nums.add(12);
		nums.add(13);
		nums.add(22);
		nums.add(23);
		printInfo("nums", nums);

		Set<String> names = new HashSet<>();
		names.add("Vinod");
		names.add("Xavior");
		names.add("Arun");
		names.addAll(Arrays.asList("Shyam", "Kishore", "Kishore", "Shyam", "Shyam"));
		printInfo("names", names);

		log.debug("Using enhanced for loop:");
		for (String name : names) {
			log.debug("{}", name);
		}
		log.debug("Using iterator: ");
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			log.debug("{}", it.next());
		}
		
		Set<Person> people = new LinkedHashSet<>();
		
		Person p1 = new Person(1, "Vinod", "Kumar", 175, 84);
		Person p2 = new Person(1, "Vinod", "Kumar", 175, 84);
		
		log.debug("p1.hashCode = {}", p1.hashCode());
		log.debug("p2.hashCode = {}", p2.hashCode());
		log.debug("p1.equals(p2) is {}", p1.equals(p2));
		
		people.add(p1);
		people.add(p2);
		people.add(new Person(2, "Shyam", "Sundar", 180, 78));
		people.add(new Person(1, "Ravi", "Kumar", 175, 84));
		people.add(new Person(1, "Vinod", "Rao", 175, 84));
		
		printInfo("people", people);
		
//		for(Person p: people) {
//			log.debug("{}", p);
//		}
//		
//		log.debug("using iterator...");
//		Iterator<Person> it1 = people.iterator();
//		
//		while(it1.hasNext()) {
//			log.debug("{}", it1.next());
//		}

	}

}
