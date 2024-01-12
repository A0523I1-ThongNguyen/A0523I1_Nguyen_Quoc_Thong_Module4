package com.example.ss4_thymeleaf_product.service;

import com.example.ss4_thymeleaf_product.model.Product;
import com.example.ss4_thymeleaf_product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id,product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> listSearch(String name) {
        return productRepository.listSearch(name);
    }
}
