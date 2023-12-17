package com.mytask.newsapp.controllers;

import com.mytask.newsapp.models.Image;
import com.mytask.newsapp.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

// RestController class that handles requests related to images
@RestController
@RequiredArgsConstructor
public class ImageController {

    // Repository for handling image-related operations
    private final ImageRepository imageRepository;

    // Method to handle requests for retrieving images by their ID
    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id) {
        // Retrieve the image by its ID from the repository
        Image image = imageRepository.findById(id).orElse(null);

        // Ensure that the image is found
        assert image != null;

        // Build and return the ResponseEntity with image data
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
