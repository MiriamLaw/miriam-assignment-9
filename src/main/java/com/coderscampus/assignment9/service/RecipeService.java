package com.coderscampus.assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.coderscampus.assignment9.domain.Recipe;

public class RecipeService {
	public static void main(String[] args) {
		List<Recipe> recipes = readRecipeFile();
		recipes.forEach(System.out::println); 
	}

	public static List<Recipe> readRecipeFile() {
		List<Recipe> recipes = new ArrayList<>();
		
		try {Reader in = new FileReader("recipes.txt");

			CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).setTrim(false)
					.build();

			Iterable<CSVRecord> records = csvFormat.parse(in);

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
		boolean dairyFree = Boolean.parseBoolean(record.get(" Dairy Free"));
		boolean glutenFree = Boolean.parseBoolean(record.get(" Gluten Free"));
		String instructions = record.get(" Instructions");
		Double preparationMinutes = Double.parseDouble(record.get(" Preparation Minutes"));
		Double pricePerServing = Double.parseDouble(record.get(" Price Per Serving"));
		Integer readyInMinutes = Integer.parseInt(record.get(" Ready In Minutes"));
		Integer servings = Integer.parseInt(record.get(" Servings"));
		Double spoonacularScore = Double.parseDouble(record.get(" Spoonacular Score"));
		String title = record.get(" Title");
		Boolean vegan = Boolean.parseBoolean(record.get(" Vegan"));
		Boolean vegetarian = Boolean.parseBoolean(record.get(" Vegetarian"));
		
		return new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes, 
				pricePerServing, readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian);
		
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
