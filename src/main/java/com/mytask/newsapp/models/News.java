package com.mytask.newsapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Model class representing news articles in the application
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    // Primary key ID, automatically generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Title of the news article
    private String title;

    // Body/content of the news article
    private String body;

    // One-to-Many relationship with the Image entity (each news article can have multiple images)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "news")
    private List<Image> images = new ArrayList<>();

    // ID of the preview image associated with the news article
    private Long previewImageId;

    // Publication date of the news article, automatically set before persisting to the database
    private String publicationDate;

    // Method annotated with @PrePersist to initialize fields before persisting to the database
    @PrePersist
    private void init() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define a custom date and time format pattern
        String pattern = "yyyy-MM-dd HH:mm:ss";

        // Create a DateTimeFormatter using the pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        // Format the LocalDateTime using the formatter
        publicationDate = currentDateTime.format(formatter);
    }

    // Method to add an image to the list of images associated with the news article
    public void addImageToNews(Image image) {
        image.setNews(this);
        images.add(image);
    }
}
