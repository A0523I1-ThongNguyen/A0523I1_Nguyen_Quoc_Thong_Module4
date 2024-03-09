package com.example.many_to_many.service;

import com.example.many_to_many.model.Product;
import com.example.many_to_many.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByCategory(Long categoryName) {
        return productRepository.findByCategoryId(categoryName);
    }
}
