package com.db.recipes.service;

import com.db.recipes.model.AudioData;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class GridFsAudioService {

    private GridFsTemplate gridFsTemplate;


    private GridFsOperations operations;

    public GridFsAudioService(GridFsTemplate gridFsTemplate, GridFsOperations operations) {
        this.gridFsTemplate = gridFsTemplate;
        this.operations = operations;
    }

    public AudioData getAudio(String id) throws IllegalStateException, IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        AudioData recipeAudio = new AudioData();
        GridFsResource resource = gridFsTemplate.getResource(file);
        recipeAudio.setTitle(file.getMetadata().get("title").toString());
        recipeAudio.setRecording(new Binary(BsonBinarySubType.BINARY, resource.getInputStream().readAllBytes()));
        return recipeAudio;
    }

    public String saveAudio(String title, MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "audio");
        metaData.put("title", title);
        ObjectId id = gridFsTemplate.store(file.getInputStream(), file.getName(), file.getContentType(), metaData);
        return id.toString();
    }
}
