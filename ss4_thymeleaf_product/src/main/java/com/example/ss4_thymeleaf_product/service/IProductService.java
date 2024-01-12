package com.example.ss4_thymeleaf_product.service;

import com.example.ss4_thymeleaf_product.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    void add(Product product);
    void delete(int id);
    void update(int id,Product product);
    Product findById(int id);

    List<Product> listSearch(String name);
}
