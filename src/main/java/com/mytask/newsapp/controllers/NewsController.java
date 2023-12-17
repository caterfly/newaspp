package com.mytask.newsapp.controllers;

import com.mytask.newsapp.models.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.mytask.newsapp.services.NewsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

// Controller class that handles requests related to news
@Controller
@RequiredArgsConstructor
public class NewsController {

    // Service responsible for handling news-related operations
    private final NewsService newsService;

    // Method to handle requests for displaying news
    @GetMapping("/")
    public String news(@RequestParam(name = "count", defaultValue = "5") int count, Model model) {
        // Add news data to the model to be displayed in the view
        model.addAttribute("news", newsService.listNews());
        model.addAttribute("count", count);
        return "news"; // Return the name of the view (news.html)
    }

    // Method to handle requests for displaying detailed information about a specific news article
    @GetMapping("/news/{id}")
    public String newInfo(@PathVariable Long id, Model model) {
        // Retrieve the news article by its ID from the service
        News news = newsService.getNewsById(id);
        // Add news and associated images to the model for display in the view
        model.addAttribute("news", news);
        model.addAttribute("images", news.getImages());
        return "news-info"; // Return the name of the view (news-info.html)
    }

    // Method to handle requests for creating new news articles
    @PostMapping("/news/create")
    public String createNews(@RequestParam("file1") MultipartFile file1, News news) throws IOException {
        // Save the news article along with an optional file (image)
        newsService.saveNews(news, file1);
        return "redirect:/"; // Redirect to the main news page after creating the news article
    }

    // Method to handle requests for deleting a news article by its ID
    @PostMapping("/news/delete/{id}")
    public String deleteNews(@PathVariable Long id) {
        // Delete the news article by its ID
        newsService.deleteNews(id);
        return "redirect:/"; // Redirect to the main news page after deleting the news article
    }
}
