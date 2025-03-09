package com.example.movieservice.service;

import com.example.movieservice.model.MovieModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MovieService {
    List<MovieModel> getAllMovies();
    MovieModel addMovie(String title, String category, Double imdbRating, MultipartFile image) throws IOException; // image parametresi eklendi
}
