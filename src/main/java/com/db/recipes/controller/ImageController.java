package com.db.recipes.controller;

import com.db.recipes.model.mongo.ImageData;
import com.db.recipes.service.GridFsImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final GridFsImageService gridFsImageService;

    @Autowired
    public ImageController(GridFsImageService gridFsImageService) {
        this.gridFsImageService = gridFsImageService;
    }

    @GetMapping(value = "/{audioId}", produces = "application/json")
    public ImageData getRecipe(@PathVariable String audioId) throws IOException {
        LOG.info("Getting all users.");
        return gridFsImageService.getImage(audioId);
    }

    @PostMapping(value = "")
    public String insertRecipe(@RequestParam("title") String title, @RequestParam("file") MultipartFile file, Model model) throws IOException {
        LOG.info("Inserting a new audio {} {}", title, file.getName());
        return gridFsImageService.saveImage(title, file);
    }
}
