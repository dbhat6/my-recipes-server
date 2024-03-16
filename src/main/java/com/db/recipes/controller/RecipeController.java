package com.db.recipes.controller;

import com.db.recipes.model.mongo.AudioData;
import com.db.recipes.model.mongo.Recipes;
import com.db.recipes.repo.RecipeRepoImpl;
import com.db.recipes.service.GridFsAudioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final RecipeRepoImpl recipeRepoImpl;
    private final GridFsAudioService gridFsAudioService;

    @Autowired
    public RecipeController(RecipeRepoImpl recipeRepoImpl, GridFsAudioService gridFsAudioService) {
        this.recipeRepoImpl = recipeRepoImpl;
        this.gridFsAudioService = gridFsAudioService;
    }

    @GetMapping(value = "/{recipeId}", produces = "application/json")
    public Recipes getRecipe(@PathVariable String recipeId) throws IOException {
        LOG.info("Getting all recipes.");
        Recipes recipeById = recipeRepoImpl.getRecipeById(recipeId);
        String vcBinaryId = recipeById.getVoiceRecording().getBinaryId();
        AudioData audioData = gridFsAudioService.getAudio(vcBinaryId);
        audioData.setBinaryId(vcBinaryId);
        recipeById.setVoiceRecording(audioData);
        return recipeById;
    }

    @PostMapping
    public Recipes insertRecipe(@RequestBody Recipes recipes) {
        LOG.info("Inserting a new recipe {} {}", recipes.getName(), recipes.getServing());
        return recipeRepoImpl.addNewRecipe(recipes);
    }
}
