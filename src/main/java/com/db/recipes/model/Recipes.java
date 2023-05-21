package com.db.recipes.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.InputStream;

@Document
public class Recipes {
    @Id
    private String recipeId;
    private String name;
    private int serving;
    private Binary image;
    private InputStream recording;

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServing() {
        return serving;
    }

    public void setServing(int serving) {
        this.serving = serving;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    public InputStream getRecording() {
        return recording;
    }

    public void setRecording(InputStream recording) {
        this.recording = recording;
    }


}
