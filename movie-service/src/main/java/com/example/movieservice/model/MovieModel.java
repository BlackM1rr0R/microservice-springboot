package com.example.movieservice.model;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "all_films")
@Getter
@Setter
public class MovieModel {
    @Id
    private String id;

    private String title;
    private String category;
    private Double imdbRating;
    private Binary image; // image değişkeni Binary türünde tanımlanmalı

    // Yapıcı, imageFile yerine image parametresini alacak
    public MovieModel(String title, String category, Double imdbRating, MultipartFile imageFile) throws IOException {
        this.title = title;
        this.category = category;
        this.imdbRating = imdbRating;
        if (imageFile != null) {
            this.image = new Binary(imageFile.getBytes()); // imageFile'i Binary'ye dönüştür
        }
    }
}
