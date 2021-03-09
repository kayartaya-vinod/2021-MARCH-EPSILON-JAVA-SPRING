package com.epsilon.training.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadFromKeyboard {
	
	public static void main(String[] args) throws IOException {
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(in);
		
		System.out.print("What's your name? ");
		String name = reader.readLine();
		System.out.print("Where are you from? ");
		String city = reader.readLine();
		
		log.debug("Hello {}, how's weather in {}?", name, city);
		
	}
	
	public static void main3(String[] args) throws IOException {
		byte[] bytes = new byte[50];
		System.out.print("Enter a text follwed by ENTER key: ");
		System.in.read(bytes);
		log.debug("bytes = {}", bytes);
		String name = new String(bytes).trim();
		System.out.println("Hello, " + name);
	}

	public static void main2(String[] args) throws IOException {
		System.out.print("Enter a text follwed by ENTER key: ");
		int ch;

		String name = "";

		while ((ch = System.in.read()) != '\n') {
			name += (char) ch;
		}

		System.out.println("Hello, " + name);
	}

	public static void main1(String[] args) throws IOException {

		log.debug("Type something and press ENTER key: ");
		// System.in represents keyboard
		int ch = System.in.read();
		log.debug("You entered: {} which represents {}", ch, (char) ch);

	}

}
