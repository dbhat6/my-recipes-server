package com.db.recipes.controller;

import com.db.recipes.model.AudioData;
import com.db.recipes.service.GridFsAudioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/audio")
public class AudioController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final GridFsAudioService gridFsAudioService;

    @Autowired(required = false)
    public AudioController(GridFsAudioService gridFsAudioService) {
        this.gridFsAudioService = gridFsAudioService;
    }

    @GetMapping(value = "/{audioId}", produces = "application/json")
    public AudioData getRecipe(@PathVariable String audioId) throws IOException {
        LOG.info("Getting all users.");
        return gridFsAudioService.getAudio(audioId);
    }

    @PostMapping(value = "")
    public String insertRecipe(@RequestParam("title") String title, @RequestParam("file") MultipartFile file, Model model) throws IOException {
        LOG.info("Inserting a new audio {} {}", title, file.getName());
        return gridFsAudioService.saveAudio(title, file);
    }
}
