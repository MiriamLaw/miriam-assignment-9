package com.coderscampus.assignment9.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.FileService;

@Service
public class RecipeRepository {
	List<Recipe> recipes = new ArrayList<>();

	@Autowired
	private FileService fileService;

	public List<Recipe> getAllRecipes() {
		if (CollectionUtils.isEmpty(recipes)) {
			recipes = fileService.readRecipeFile();

		}

		return recipes;
	}

}
