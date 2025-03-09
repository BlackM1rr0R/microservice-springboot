package com.example.subcategoriesservice.service;

import com.example.subcategoriesservice.model.SubCategory;
import com.example.subcategoriesservice.repository.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    public SubCategory addSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    public List<SubCategory> getSubCategoriesByCategoryId(String categoryId) {
        return subCategoryRepository.findByCategoryId(categoryId);
    }

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }
}
