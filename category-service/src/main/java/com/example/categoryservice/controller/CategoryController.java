package com.example.categoryservice.controller;

import com.example.categoryservice.model.Category;
import com.example.categoryservice.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }
    @GetMapping()
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
