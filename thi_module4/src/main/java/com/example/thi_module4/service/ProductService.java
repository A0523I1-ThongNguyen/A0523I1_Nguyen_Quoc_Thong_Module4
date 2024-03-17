package com.example.thi_module4.service;

import com.example.thi_module4.model.Product;
import com.example.thi_module4.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void add(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Product findByID(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> searchByName(Pageable pageable, String name) {
        return iProductRepository.searchByName(pageable,name);
    }

    @Override
    public Page<Product> searchByPrice(Pageable pageable, double price) {
        return iProductRepository.searchByPrice(pageable,price);
    }

    @Override
    public Page<Product> searchByCate(Pageable pageable, Long category) {
        return iProductRepository.searchByCate(pageable,category);
    }

    @Override
    public Page<Product> searchAll(Pageable pageable, String tivi, double price) {
        return iProductRepository.searchAll(pageable,tivi,price);
    }
}
