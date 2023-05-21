package com.db.recipes.controller;

import com.db.recipes.model.Recipes;
import com.db.recipes.repo.RecipeRepoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final RecipeRepoImpl recipeRepoImpl;

    @Autowired(required = false)
    public RecipeController(RecipeRepoImpl recipeRepoImpl) {
        this.recipeRepoImpl = recipeRepoImpl;
    }

    @GetMapping(value="/status", produces = "application/json")
    public String applicationUp() {
        return "The application is up";
    }

    @GetMapping(value = "/recipe/{recipeId}", produces = "application/json")
    public List<Recipes> getRecipe(@PathVariable String recipeId) {
        LOG.info("Getting all users.");
        return recipeRepoImpl.getAllRecipes();
    }

    @PostMapping(value = "/recipes")
    public Recipes insertRecipe(@RequestBody Recipes recipes) {
        LOG.info("Inserting a new recipe {} {}", recipes.getName(), recipes.getServing());
        return recipeRepoImpl.addNewRecipe(recipes);

    }
}
