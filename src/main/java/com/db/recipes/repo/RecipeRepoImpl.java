package com.db.recipes.repo;

import com.db.recipes.model.Recipes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipeRepoImpl implements RecipeRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Recipes> getAllRecipes() {
        return mongoTemplate.findAll(Recipes.class);
    }

    @Override
    public Recipes getRecipeById(String recipeId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("recipeId").is(recipeId));
        return mongoTemplate.findOne(query, Recipes.class);
    }

    @Override
    public Recipes getRecipeByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Recipes.class);
    }

    @Override
    public Recipes addNewRecipe(Recipes recipes) {
        mongoTemplate.save(recipes);
        // Now, user object will contain the ID as well
        return recipes;
    }

    @Override
    public Object getAllRecipeSettings(String recipeId) {
        return null;
    }

    @Override
    public String getRecipeSetting(String recipeId, String key) {
        return null;
    }

    @Override
    public String addRecipeSetting(String recipeId, String key, String value) {
        return null;
    }
}
