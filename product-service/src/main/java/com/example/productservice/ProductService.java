package com.example.productservice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByUserId(Long userId) {
        return productRepository.findByUserId(userId);
    }

    public List<Product> getProductsBySubcategoryId(String subcategoryId) {
        return productRepository.findBySubcategoryId(subcategoryId);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
