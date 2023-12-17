# NewsApp Project

NewsApp is a simple web application for managing news articles. It allows users to view a list of news articles, read more details about a specific article, create new articles, and delete existing ones. The project is implemented using Java with the Spring Boot framework for the backend, Thymeleaf for templating, and HTML for the frontend.

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- View a list of news articles with a specified number of items.
- Read detailed information about a specific news article.
- Create a new news article with a title, body, and an optional image.
- Delete existing news articles.

## Project Structure

The project consists of the following components:

- **Controllers:**
    - `NewsController`: Handles requests related to news articles.
    - `ImageController`: Manages requests for retrieving images by ID.

- **Models:**
    - `News`: Represents a news article with title, body, publication date, and associated images.
    - `Image`: Represents an image with attributes such as name, size, content type, and image data.

- **Repositories:**
    - `NewsRepository`: Handles database operations for news articles.
    - `ImageRepository`: Manages database operations for images.

- **Services:**
    - `NewsService`: Contains business logic for news-related operations.

- **Views:**
    - HTML templates using freemarker for rendering dynamic content.

## Setup and Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/caterfly/newsapp.git
   cd newsapp
