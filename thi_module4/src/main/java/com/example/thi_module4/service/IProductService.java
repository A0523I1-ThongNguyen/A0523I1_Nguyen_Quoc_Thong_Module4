package com.example.thi_module4.service;

import com.example.thi_module4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    List<Product> findAll();
    void add(Product product);
    void delete(Long id);
    Product findByID(Long id);
    Page<Product> searchByName(Pageable pageable, String name);
    Page<Product> searchByPrice(Pageable pageable, double price);
    Page<Product> searchByCate(Pageable pageable,  Long category);
    Page<Product> searchAll(Pageable pageable, String tivi, double price);
}
