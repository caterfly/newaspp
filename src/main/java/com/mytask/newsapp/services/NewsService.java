package com.mytask.newsapp.services;

import com.mytask.newsapp.models.Image;
import com.mytask.newsapp.models.News;
import com.mytask.newsapp.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

// Service class responsible for handling business logic related to news articles
@Service
@Slf4j
@RequiredArgsConstructor
public class NewsService {

    // Repository for handling news-related operations
    private final NewsRepository newsRepository;

    // Method to retrieve a list of all news articles
    public List<News> listNews() {
        return newsRepository.findAll();
    }

    // Method to save a new news article along with an optional image file
    public void saveNews(News news, MultipartFile file1) throws IOException {
        Image image1;

        // Check if the file1 (image) is present
        if (file1.getSize() != 0) {
            // Convert the MultipartFile to an Image entity
            image1 = toImageEntity(file1);
            // Set the image as a preview image
            image1.setPreviewImage(true);
            // Add the image to the news article
            news.addImageToNews(image1);
        }

        // Log the information about the news article being saved
        log.info("Saving New. Title: {}", news.getTitle());

        // Save the news article to the database
        News newsFromDb = newsRepository.save(news);

        // Set the preview image ID based on the first image in the news article
        newsFromDb.setPreviewImageId(newsFromDb.getImages().get(0).getId());

        // Save the news article again to update the preview image ID
        newsRepository.save(news);
    }

    // Method to convert a MultipartFile to an Image entity
    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    // Method to delete a news article by its ID
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    // Method to retrieve a news article by its ID
    public News getNewsById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }
}
