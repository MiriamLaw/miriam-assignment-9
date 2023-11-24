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
		expectedRecipes.add(new Recipe(
				30, true, true, "Follow the instructions on the box.",
				10.0, 5.99, 40, 4, 8.5, "Delicious Pasta", true, false
				));
		
		Mockito.when(recipeRepository.getAllRecipes()).thenReturn(expectedRecipes);
		
		List<Recipe> actualRecipes = recipeService.getAllRecipes();
		
		assertEquals(expectedRecipes.size(), actualRecipes.size());
	}
	
	@Test
	void testGetGlutenFreeRecipes() throws Exception {
		List<Recipe> allRecipes = new ArrayList<>();
		
		Recipe glutenFreeRecipe = new Recipe(30, true, true, "Season the liver lightly with salt and pepper;",
	            10.0, 5.99, 40, 4, 8.5, "Delicious Pasta", true, false);
		
		allRecipes.add(glutenFreeRecipe);
		
		Recipe nonGlutenFreeRecipe = new Recipe(25, false, false, "Preheat the oven to 325F. Line 12 muffin tins with paper liners.",
	            15.0, 6.99, 35, 6, 7.5, "Muffins", false, true);
		
		allRecipes.add(nonGlutenFreeRecipe);
		
		Mockito.when(recipeRepository.getAllRecipes()).thenReturn(allRecipes);
		
		List<Recipe> glutenFreeRecipes = recipeService.getGlutenFreeRecipes();
		
		for (Recipe recipe : glutenFreeRecipes) {
			assertTrue(recipe.getGlutenFree());
		}
	}
	
	@Test
	void testGetVeganRecipes() throws Exception {
		
	}
	
	@Test
	void testVeganAndGlutenFreeRecipes() throws Exception {
		
	}
	
	@Test
	void testVegetarianRecipes() throws Exception {
		
	}

}
