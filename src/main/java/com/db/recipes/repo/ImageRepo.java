package com.db.recipes.repo;

import com.db.recipes.model.mongo.ImageData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepo extends MongoRepository<ImageData, String> {
}
