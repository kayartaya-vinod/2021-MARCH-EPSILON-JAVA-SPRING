package com.epsilon.training.resources;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloService {

	private String createMessage(String name) {
		if (name == null) {
			name = "friend";
		}
		return String.format("Hello %s, How are you doing?", name);
	}

	@GetMapping(path = { "", "/{name}" }, produces = "text/plain")
	public String sayHello(@PathVariable(required = false, name = "name") String name) {
		return createMessage(name);
	}

	@GetMapping(path = { "", "/{name}" }, produces = "application/json")
	public Map<String, Object> sayHelloInJson(@PathVariable(required = false, name = "name") String name) {

		Map<String, Object> map = new LinkedHashMap<>();
		map.put("message", createMessage(name));
		map.put("timestamp", new Date());
		return map;
	}
}
