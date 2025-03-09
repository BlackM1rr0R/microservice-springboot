package com.example.movieservice.controller;

import com.example.movieservice.model.MovieModel;
import com.example.movieservice.service.MovieService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/films")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public MovieModel addMovie(
            @RequestParam String title,
            @RequestParam String category,
            @RequestParam Double imdbRating,
            @RequestParam(required = false) MultipartFile image
    ) throws IOException {
        return movieService.addMovie(title, category, imdbRating, image);
    }
    @GetMapping("/all")
    public List<MovieModel> getAllMovies() {
        return movieService.getAllMovies();
    }
}
