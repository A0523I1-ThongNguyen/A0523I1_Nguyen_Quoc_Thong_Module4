package com.example.ss10_session_cookie.service;

import com.example.ss10_session_cookie.model.Product;
import com.example.ss10_session_cookie.repository.IProductRepository;
import com.example.ss10_session_cookie.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return iProductRepository.findById(id).orElse(null);
    }
}