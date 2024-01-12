package com.example.ss5_orm_product.repository;

import com.example.ss5_orm_product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void add(Product product);

    Product findById(int id);
    void delete(int id);
    void update(Product newProduct, Product productUp);
}
