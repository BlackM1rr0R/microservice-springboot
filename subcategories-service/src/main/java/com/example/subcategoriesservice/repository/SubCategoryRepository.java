package com.example.subcategoriesservice.repository;

import com.example.subcategoriesservice.model.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends MongoRepository<SubCategory, String> {

    List<SubCategory> findByCategoryId(String categoryId);
}
