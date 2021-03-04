package com.epsilon.training.utils;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XmlReader implements Closeable{

	public XmlReader() throws FileNotFoundException {
		log.debug("XmlReader instantiated!");
		//throw new FileNotFoundException("Unable to locate the file...");
	}

	public void read() throws IOException {
		log.debug("Reading xml....");
		throw new IOException("unable to read XML file..");
	}

	public void close() throws IOException {
		log.debug("Releasing any system resources used by the XmlReader...");
	}

}
