package com.epsilon.training.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.epsilon.training.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsingLists {

	static void printInfo(String varName, List<?> list) {
		log.debug("{}  contains {} elements", varName, list.size());
		log.debug("{} = {}", varName, list);
		log.debug("");
	}

	public static void main(String[] args) {

		// NOTE: Always create variables/parameters/return-types of interface types; not
		// class types
		List<Integer> nums = new ArrayList<>();

		nums.add(12);
		nums.add(22);
		nums.add(12);
		nums.add(2232);
		nums.add(3);

		printInfo("nums", nums);
		nums.add(100);
		nums.add(2, 200);
		printInfo("nums", nums);

		nums.remove(3); // not an object being deleted; but object at index 3 is deleted.
		printInfo("nums", nums);

		nums.remove(new Integer(2232));
		printInfo("nums", nums);

		List<String> names = new LinkedList<>();
		names.add("Vinod");
		names.addAll(Arrays.asList("Shyam", "Kiran", "Kishore", "Harish", "Naveen"));
		printInfo("names", names);
		
		names.set(2, "Kiran Kumar");
		names.add(2, "Sanjeev");

		for (int i = 0, j = names.size(); i < j; i++) {
			log.debug("names.get({}) is {}", i, names.get(i));
		}
		
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "Vinod", "Kumar", 175, 84));
		people.add(new Person(1, "Vinod", "Kumar", 175, 84));
		people.add(new Person(2, "Shyam", "Sundar", 180, 78));
		people.add(new Person(1, "Ravi", "Kumar", 175, 84));
		people.add(new Person(1, "Vinod", "Rao", 175, 84));
		
		printInfo("people", people);
		
		for(Person p: people) {
			log.debug("{}", p);
		}
		
		log.debug("using iterator...");
		Iterator<Person> it = people.iterator();
		
		while(it.hasNext()) {
			log.debug("{}", it.next());
		}

	}

}
