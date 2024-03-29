package com.example.ss4_product_thymeleaf.service;

import com.example.ss4_product_thymeleaf.model.Product;

import com.example.ss4_product_thymeleaf.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> show() {
        return iProductRepository.show();
    }

    @Override
    public void add(Product product) {
        iProductRepository.add(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepository.update(id, product);
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }

    @Override
    public List<Product> search(String productName) {
        return iProductRepository.search(productName);
    }
}
