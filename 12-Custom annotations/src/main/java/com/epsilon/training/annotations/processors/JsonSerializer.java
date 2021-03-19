package com.epsilon.training.annotations.processors;

import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.epsilon.training.annotations.JsonProperty;
import com.epsilon.training.annotations.JsonSerializable;
import com.epsilon.training.entity.JsonIgnored;
import com.epsilon.training.exceptions.NotJsonSerializableException;

public class JsonSerializer {
	
	public void serialize(Writer writer, Object obj) {
		String json = this.serialize(obj);
		try(PrintWriter out = new PrintWriter(writer);){
			out.print(json);
		}
	}

	public String serialize(Object obj) {

		if (obj == null) {
			throw new NotJsonSerializableException("Cannot serialize a null object!");
		}

		// cls represents the class, obj is an object of
		Class<?> cls = obj.getClass();

		if (!cls.isAnnotationPresent(JsonSerializable.class)) {
			throw new NotJsonSerializableException("The class " + cls.getName() + " does not have @JsonSerializable");
		}

		List<String> kvList = new ArrayList<>();
		for (Field f : cls.getDeclaredFields()) {
			if (!f.isAnnotationPresent(JsonIgnored.class)) {
				try {
					
					String label = f.getName();
					
					
					JsonProperty ann = f.getAnnotation(JsonProperty.class);
					if(ann!=null) {
						label = ann.label();
						if(label ==null || label.trim().equals("")) {
							label = f.getName();
						}
					}
					
					f.setAccessible(true);
					String kv = String.format("\"%s\": \"%s\"", label, f.get(obj));
					kvList.add(kv);
				} catch (Exception e) {
					System.err.println("Erorr for field " + f.getName() + " - " + e.getMessage());
				}
			}
		}

		StringBuffer sb = new StringBuffer(1000);
		sb.append("{");
		for (int i = 0, j = kvList.size() - 1; i < j; i++) {
			sb.append(kvList.get(i));
			sb.append(", ");
		}
		sb.append(kvList.get(kvList.size() - 1));
		sb.append("}");

		return sb.toString();
	}
}
