package com.coderscampus.assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.repo.RecipeRepository;
import com.coderscampus.assignment9.service.RecipeService;

@SpringBootTest
class Assignment9ApplicationTests {

	@InjectMocks
	private RecipeService recipeService;

	@Mock
	private RecipeRepository recipeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetAllRecipes() throws Exception {

		List<Recipe> expectedRecipes = new ArrayList<>();
		expectedRecipes.add(new Recipe(30, true, true, "Follow the instructions on the box.", 10.0, 5.99, 40, 4, 8.5,
				"Delicious Pasta", true, false));

		Mockito.when(recipeRepository.getAllRecipes()).thenReturn(expectedRecipes);

		List<Recipe> actualRecipes = recipeService.getAllRecipes();

		assertEquals(expectedRecipes.size(), actualRecipes.size());
	}

	@Test
	void testGetGlutenFreeRecipes() throws Exception {
		List<Recipe> allRecipes = new ArrayList<>();

		Recipe glutenFreeRecipe = new Recipe(30, true, true, "Season the liver lightly with salt and pepper;", 10.0,
				5.99, 40, 4, 8.5, "Delicious Pasta", true, false);

		allRecipes.add(glutenFreeRecipe);

		Recipe nonGlutenFreeRecipe = new Recipe(25, false, false,
				"Preheat the oven to 325F. Line 12 muffin tins with paper liners.", 15.0, 6.99, 35, 6, 7.5, "Muffins",
				false, true);

		allRecipes.add(nonGlutenFreeRecipe);

		Mockito.when(recipeRepository.getAllRecipes()).thenReturn(allRecipes);

		List<Recipe> glutenFreeRecipes = recipeService.getGlutenFreeRecipes();

		for (Recipe recipe : glutenFreeRecipes) {
			assertTrue(recipe.getGlutenFree());
		}
	}

	@Test
	void testGetVeganRecipes() throws Exception {
		List<Recipe> allRecipes = new ArrayList<>();

		Recipe veganRecipe = new Recipe(45, true, true,
				"1. Place the lentils, turmeric, salt and water in a large saucepan", 15.0, 59.89, 60, 6, 63.0,
				"Zucchini with Lentils and Roasted Garlic", true, true);

		allRecipes.add(veganRecipe);

		Recipe nonVeganRecipe = new Recipe(135, false, false,
				"1 Heat oven to 350F. Grease bottom and sides of 13x9-inch pan with shortening", 30.0, 99.92, 165, 12,
				54.0, "Butterfly Stencil Cake", false, false);

		allRecipes.add(nonVeganRecipe);

		Mockito.when(recipeRepository.getAllRecipes()).thenReturn(allRecipes);
		List<Recipe> veganRecipes = recipeService.getVeganRecipes();

		for (Recipe recipe : veganRecipes) {
			assertTrue(recipe.getVegan());
		}
	}

	@Test
	void testVeganAndGlutenFreeRecipes() throws Exception {
		List<Recipe> allRecipes = new ArrayList<>();

		Recipe veganAndGlutenFreeRecipe = new Recipe(40, true, true,
				"To Make The Almond Topping:Stir all ingredients together until combined", 5.0, 118.77, 45, 8, 39.0,
				"Berry Almond Crisp", true, true);

		allRecipes.add(veganAndGlutenFreeRecipe);

		Recipe nonVeganAndGlutenFreeRecipe = new Recipe(0, false, false, "Procedures 1 Make the crust", 0.0, 131.78, 75,
				8, 34.0, "Meyer Lemon Mascarpone Cake", false, false);

		allRecipes.add(nonVeganAndGlutenFreeRecipe);

		Mockito.when(recipeRepository.getAllRecipes()).thenReturn(allRecipes);

		List<Recipe> veganAndGlutenFreeRecipes = recipeService.getVeganAndGlutenFreeRecipes();

		for (Recipe recipe : veganAndGlutenFreeRecipes) {
			assertTrue(recipe.getVegan());
			assertTrue(recipe.getGlutenFree());
		}

	}

	@Test
	void testVegetarianRecipes() throws Exception {
		List<Recipe> allRecipes = new ArrayList<>();

		Recipe vegetarianRecipe = new Recipe(45, true, true,
				"1. Place the lentils, turmeric, salt and water in a large saucepan", 15.0, 59.89, 60, 6, 63.0,
				"Zucchini with Lentils and Roasted Garlic", true, true);

		allRecipes.add(vegetarianRecipe);

		Recipe nonVegetarianRecipe = new Recipe(135, false, false,
				"1 Heat oven to 350F. Grease bottom and sides of 13x9-inch pan with shortening", 30.0, 99.92, 165, 12,
				54.0, "Butterfly Stencil Cake", false, false);

		allRecipes.add(nonVegetarianRecipe);

		Mockito.when(recipeRepository.getAllRecipes()).thenReturn(allRecipes);
		List<Recipe> vegetarianRecipes = recipeService.getVegetarianRecipes();

		for (Recipe recipe : vegetarianRecipes) {
			assertTrue(recipe.getVegetarian());
		}

	}

}
