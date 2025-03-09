package com.example.movieservice.repository;

import com.example.movieservice.model.MovieModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<MovieModel,String> {

}
