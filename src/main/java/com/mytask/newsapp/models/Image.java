package com.mytask.newsapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity class representing an image in the application
@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    // Primary key ID, automatically generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Image name
    private String name;

    // Original file name of the image
    private String originalFileName;

    // Size of the image in bytes
    private Long size;

    // Content type (MIME type) of the image
    private String contentType;

    // Flag indicating whether the image is a preview image
    private boolean isPreviewImage;

    // Byte array representing the image data
    @Lob
    private byte[] bytes;

    // Many-to-One relationship with the News entity (each image is associated with a news article)
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private News news;
}
