package com.motivity.streamsApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.motivity.streamsApi.model.ModelClass;

public class SteamExample {
	
	public static void main(String[] args) {
		Map<String, ModelClass> map = new HashMap<>();
		List<String> roles = new ArrayList<>(Arrays.asList("ADMIN","USER"));
		ModelClass class1 = new ModelClass("xyz", "Java", roles);
		map.put("xyz@motivity.com", class1);
		
		
		List<String> roles2 = new ArrayList<>(Arrays.asList("ADMIN"));
		ModelClass class2 = new ModelClass("Abc", "Python", roles2);
		map.put("abc@motivity.com", class2);
		
		List<String> roles3 = new ArrayList<>();
		ModelClass class3 = new ModelClass("mno", ".net", roles3);
		map.put("mno@motivity.com", class3);
		
		map.entrySet().stream().filter(t -> (t.getValue().getRoles().size()!=0))
		.forEach(System.out::println);
		
	}

}
