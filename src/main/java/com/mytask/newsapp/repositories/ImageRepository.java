package com.mytask.newsapp.repositories;

import com.mytask.newsapp.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository interface for performing CRUD operations on the Image entity
public interface ImageRepository extends JpaRepository<Image, Long> {
}
