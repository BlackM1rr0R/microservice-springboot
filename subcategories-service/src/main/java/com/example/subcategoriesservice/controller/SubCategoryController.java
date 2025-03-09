package com.example.subcategoriesservice.controller;

import com.example.subcategoriesservice.model.SubCategory;
import com.example.subcategoriesservice.service.SubCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategories")
public class SubCategoryController {
    private final SubCategoryService subCategoryService;
    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }
    @PostMapping("/add")
    public SubCategory addSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryService.addSubCategory(subCategory);
    }

    @GetMapping("/{categoryId}")
    public List<SubCategory> getSubCategoriesByCategory(@PathVariable String categoryId) {
        return subCategoryService.getSubCategoriesByCategoryId(categoryId);
    }

    @GetMapping
    public List<SubCategory> getAllSubCategories() {
        return subCategoryService.getAllSubCategories();
    }
}
