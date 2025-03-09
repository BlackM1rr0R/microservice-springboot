package com.example.movieservice.service;

import com.example.movieservice.model.MovieModel;
import com.example.movieservice.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieModel> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public MovieModel addMovie(String title, String category, Double imdbRating, MultipartFile image) throws IOException {
        // MultipartFile image parametresini MovieModel'e doğru şekilde ilet
        MovieModel movieModel = new MovieModel(title, category, imdbRating, image);
        return movieRepository.save(movieModel);
    }
}
