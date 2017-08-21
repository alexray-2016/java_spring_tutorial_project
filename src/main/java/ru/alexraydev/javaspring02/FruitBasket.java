package ru.alexraydev.javaspring02;

import java.util.Map;

public class FruitBasket {
	private String name;
	private Map<String, String> fruits;
	
	public FruitBasket(String name, Map<String, String> fruits) {
		this.name = name;
		this.fruits = fruits;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(name);
		sb.append(" contains:\n");
		
		for(Map.Entry<String, String> pair : fruits.entrySet()) {
			sb.append(pair.getKey())
                    .append(" ")
                    .append(pair.getValue())
                    .append("\n");
		}
		
		return sb.toString();
	}
}
