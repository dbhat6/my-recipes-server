package com.db.recipes.model.mongo;

import com.db.recipes.model.Quantity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document
@Data
public class Recipes {
    @Id
    private String recipeId;
    private String name;
    private int serving;
    private Map<String, Quantity> ingredients;
    private List<String> steps;
    @DBRef
    private ImageData image;
    private AudioData voiceRecording;
}
