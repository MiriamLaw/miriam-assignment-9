package com.coderscampus.assignment9.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.repo.RecipeRepository;


@Service
public class RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public List<Recipe> getAllRecipes() {
		return recipeRepository.getAllRecipes();
	}

	public List<Recipe> getGlutenFreeRecipes() {
		return getAllRecipes().stream().filter(Recipe::getGlutenFree).collect(Collectors.toList());
	}

	public List<Recipe> getVeganRecipes() {
		return getAllRecipes().stream()
							  .filter(Recipe::getVegan)
							  .collect(Collectors.toList());
	}
	
	public List<Recipe> getVeganAndGlutenFreeRecipes() {
		return getAllRecipes().stream()
						      .filter(recipe -> recipe.getVegan() && recipe.getGlutenFree())
						      .collect(Collectors.toList());
	}
	
	public List<Recipe> getVegetarianRecipes() {
		return getAllRecipes().stream()
							  .filter(Recipe::getVegetarian)
							  .collect(Collectors.toList());
	}

}
