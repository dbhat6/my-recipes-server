package com.db.recipes.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.InputStream;

@Document
public class AudioData {
    @Id
    private String binaryId;
    private String title;
    private Binary recording;

    public String getBinaryId() {
        return binaryId;
    }

    public void setBinaryId(String binaryId) {
        this.binaryId = binaryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Binary getRecording() {
        return recording;
    }

    public void setRecording(Binary recording) {
        this.recording = recording;
    }
}
