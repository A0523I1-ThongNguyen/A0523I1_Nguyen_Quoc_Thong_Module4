package com.example.test_validate.service.brand;

import com.example.test_validate.model.Brand;

import java.util.List;

public interface IBrandService {
    void save(Brand brand);
    List<Brand> findAll();
    Brand findById(Long id);
}
