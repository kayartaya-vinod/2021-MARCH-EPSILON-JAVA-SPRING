package com.epsilon.training.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckedAndUncheckedExceptions {

	public static void main(String[] args) {

		String str = "1234";
		int n1 = Integer.parseInt(str);

		String filename = "pomq.xml";
		FileReader reader = null;

		try {
			reader = new FileReader(filename);
			log.debug("The file \"{}\" exists!", filename);
			int n = 100 / 0; // goes to finally, closes reader, and then breaks execution

		} catch (FileNotFoundException e) {
			log.warn("The file \"{}\" does not seem to exist!", filename);
		} finally {
			try {

				if (reader != null) {
					log.debug("closing reader");
					reader.close();
					log.debug("reader closed");
				}

			} catch (IOException e) {
				log.debug("could not close reader");
				e.printStackTrace();
			}
		}

		log.debug("n1 is {}", n1);

	}

}
