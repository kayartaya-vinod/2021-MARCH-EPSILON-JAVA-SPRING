package com.epsilon.training.programs;

import java.io.BufferedReader;
import java.io.FileReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadFromFile {
	
	public static void main(String[] args) {
		String filename = "src/main/java/com/epsilon/training/programs/ReadFromKeyboard.java";
		
		try(FileReader file = new FileReader(filename);
				BufferedReader in = new BufferedReader(file)) {
			String line;
			
			while((line = in.readLine())!=null) {
				System.out.println(line);
			}
		} // both "in" and "file" get closed over here
		catch(Exception e) {
			log.warn("There was an error - {}", e.getMessage());
		}
	}

	public static void main1(String[] args) throws Exception {
		
		
		// String filename = "pom.xml"; // path is relative from current project directory
		
		String filename = "src/main/java/com/epsilon/training/programs/ReadFromKeyboard.java";
		
		
		try(FileReader reader = new FileReader(filename)) {
			
			int ch;
			while((ch=reader.read())!=-1) {
				System.out.print((char)ch);
			}
			
		} // reader.close() is called automatically here!
		
	}
	
}
