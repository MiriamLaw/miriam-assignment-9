package com.coderscampus.assignment9.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeRestController {

	private final RecipeService recipeService;

	@Autowired
	public RecipeRestController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping("/all")
	public List<Recipe> getAllRecipes() {
		return recipeService.getAllRecipes();
	}

	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFreeRecipes() {
		return recipeService.getGlutenFreeRecipes();
	}

	@GetMapping("/vegan")
	public List<Recipe> getVeganRecipes() {
		return recipeService.getVeganRecipes();
	}

	@GetMapping("vegan-and-gluten-free")
	public List<Recipe> getVeganAndGlutenFreeRecipes() {
		return recipeService.getVeganAndGlutenFreeRecipes();
	}

	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarianRecipes() {
		return recipeService.getVegetarianRecipes();
	}
}
