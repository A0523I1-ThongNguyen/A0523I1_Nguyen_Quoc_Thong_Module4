package com.example.many_many.service;

import com.example.many_many.model.Product;
import com.example.many_many.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
    public List<Product> getProductsByCategory2() {
        return productRepository.findByCategoryId2();
    }
}
