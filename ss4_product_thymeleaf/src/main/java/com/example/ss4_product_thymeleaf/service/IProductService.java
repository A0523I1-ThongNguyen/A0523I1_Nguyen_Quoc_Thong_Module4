package com.example.ss4_product_thymeleaf.service;

import com.example.ss4_product_thymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> show();

    void add(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void delete(int id);

    List<Product> search(String productName);
}
