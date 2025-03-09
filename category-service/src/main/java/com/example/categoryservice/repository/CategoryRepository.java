package com.example.categoryservice.repository;

import com.example.categoryservice.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    boolean existsByCategoryname(String categoryname);
}
