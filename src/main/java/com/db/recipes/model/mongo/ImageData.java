package com.db.recipes.model.mongo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class ImageData {
    @Id
    private String binaryId;
    private String title;
    private Binary image;
}
