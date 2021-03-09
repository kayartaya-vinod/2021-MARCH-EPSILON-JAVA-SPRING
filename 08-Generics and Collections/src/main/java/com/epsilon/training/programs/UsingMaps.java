package com.epsilon.training.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsingMaps {

	public static void main(String[] args) {

		Map<Integer, String> people = new HashMap<>();
		people.put(1122, "Vinod Kumar");
		people.put(8273, "Shyam Sundar");
		people.put(1234, "Vinod Kumar");
		people.put(8273, "Ravi Kumar");
		people.put(8383, "John Jacob");
		people.put(8437, "Robert Williums");
		
		log.debug("There are {} entries in the map people", people.size());
		log.debug("Value for key {} is {}", 1122, people.get(1122));
		log.debug("Value for key {} is {}", 8383, people.get(8383));
		log.debug("Value for key {} is {}", 1010, people.get(1010));
		
	
		log.debug("Keys: ");
		// getting the set of keys
		for(Integer key: people.keySet()) {
			log.debug("{}", key);
		}
		
		log.debug("Values: ");
		// getting the list of values 
		for(String val: people.values()) {
			log.debug("{}", val);
		}
		
		log.debug("Entries: ");
		// getting the set of entry objects
		for(Entry<Integer, String> en: people.entrySet()) {
			log.debug("key = {}, value = {} of type {}", en.getKey(), en.getValue(), en.getClass().getName());
		}
		
	}
}
