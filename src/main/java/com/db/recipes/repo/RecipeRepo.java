package com.db.recipes.repo;

import com.db.recipes.model.Recipes;

import java.util.List;

public interface RecipeRepo {
    List<Recipes> getAllRecipes();

    Recipes getRecipeById(String recipeId);

    Recipes getRecipeByName(String recipeId);

    Recipes addNewRecipe(Recipes recipes);

    Object getAllRecipeSettings(String recipeId);

    String getRecipeSetting(String recipeId, String key);

    String addRecipeSetting(String recipeId, String key, String value);
}
