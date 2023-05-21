package com.db.recipes.service;

import com.db.recipes.model.ImageData;
import com.db.recipes.repo.ImageRepo;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class GridFsImageService {
    private GridFsTemplate gridFsTemplate;
    private ImageRepo imageRepo;
    private GridFsOperations operations;

    public GridFsImageService(GridFsTemplate gridFsTemplate, ImageRepo imageRepo, GridFsOperations operations) {
        this.gridFsTemplate = gridFsTemplate;
        this.imageRepo = imageRepo;
        this.operations = operations;
    }

    public ImageData getImage(String id) throws IllegalStateException, IOException {
        ImageData imageData = imageRepo.findById(id).get();
        return imageData;
    }

    public String saveImage(String title, MultipartFile file) throws IOException {
        ImageData image = new ImageData();
        image.setTitle(title);
        image.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        image = imageRepo.save(image);
        return image.getBinaryId();
    }
}