package com.coderscampus.assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment9.domain.Recipe;


@Service
public class RecipeService {
	public static void main(String[] args) {
		readRecipeFile();
	}
	
	public List<String> readFile(String fileName) throws IOException {
		return Files.readAllLines(Paths.get(fileName));
		
	}


	public static List<Recipe> readRecipeFile() {
	    List<Recipe> recipes = new ArrayList<>();

	    try (Reader in = new FileReader("recipes.txt")) {
			CSVFormat csvFormat = CSVFormat.Builder.create()
	        		.setHeader()
	        		.setSkipHeaderRecord(true)
	        		.setTrim(true)
	        		.setQuote('"')
			        .build();
	        
	        CSVParser parser = csvFormat.parse(in);
	        
	        List<String> headerNames = parser.getHeaderNames();
	        System.out.println("Header Names: " + headerNames);
	        	
	        Iterable<CSVRecord> records = parser.getRecords();
	        		
	        		for (CSVRecord record : records) {
	        			try {
	        				Recipe recipe = parseRecipe(record);
	        				recipes.add(recipe);
	        			} catch (IllegalArgumentException e) {
	        				System.err.println("Error parsing record: " + e.getMessage());
	        			}
	        }

	    } catch (IOException e) {
	    	e.printStackTrace();
	        }
	    return recipes;
	    }

	
	
	private static Recipe parseRecipe(CSVRecord record) {
		int cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
		boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
		boolean glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
		String instructions = record.get("Instructions");
		Double preparationMinutes = Double.parseDouble(record.get("Preparation Minutes"));
		Double pricePerServing = Double.parseDouble(record.get("Price Per Serving"));
		Integer readyInMinutes = Integer.parseInt(record.get("Ready In Minutes"));
		Integer servings = Integer.parseInt(record.get("Servings"));
		Double spoonacularScore = Double.parseDouble(record.get("Spoonacular Score"));
		String title = record.get("Title");
		Boolean vegan = Boolean.parseBoolean(record.get("Vegan"));
		Boolean vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));
		
		System.out.println("Cooking Minutes: " + cookingMinutes);
		System.out.println("Dairy Free: " + dairyFree);

		return new Recipe();
		
		
	}

	private static int safeParseInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private static double safeParseDouble(String value) {
		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}

}
