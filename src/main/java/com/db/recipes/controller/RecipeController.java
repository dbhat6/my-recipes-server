package com.db.recipes.controller;

import com.db.recipes.model.Recipes;
import com.db.recipes.repo.RecipeRepoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final RecipeRepoImpl recipeRepoImpl;

    @Autowired(required = false)
    public RecipeController(RecipeRepoImpl recipeRepoImpl) {
        this.recipeRepoImpl = recipeRepoImpl;
    }

    @GetMapping(value = "/{recipeId}", produces = "application/json")
    public Recipes getRecipe(@PathVariable String recipeId) {
        LOG.info("Getting all users.");
        return recipeRepoImpl.getRecipeById(recipeId);
    }

    @PostMapping(value = "")
    public Recipes insertRecipe(@RequestBody Recipes recipes) {
        LOG.info("Inserting a new recipe {} {}", recipes.getName(), recipes.getServing());
        return recipeRepoImpl.addNewRecipe(recipes);

    }
}
