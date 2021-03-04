package com.epsilon.training.programs;

import java.io.IOException;

import com.epsilon.training.utils.XmlReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TryWithResourceDemo {

	public static void main(String[] args) {
		log.debug("start of main");
		
		try(XmlReader reader = new XmlReader()) {
			log.debug("using reader to read XML");
			reader.read();
		} // reader.close() is automatically called here
		catch(Exception e) {
			log.warn("There was an error - {}", e.getMessage());
		}
		
		log.debug("end of main");
	}
	
	public static void main1(String[] args) {

		XmlReader reader = null;

		try {
			log.debug("instantiating XmlReader...");
			reader = new XmlReader();

			log.debug("using reader to read XML");
			reader.read();

		} catch (IOException e) {
			log.warn("There was an error");
		} finally {
			if (reader != null) {
				try {
					log.debug("trying to close reader");
					reader.close();
					log.debug("reader closed");
				} catch (IOException e) {
					log.warn("could not close reader");
				}
			}
		}
	}

}
