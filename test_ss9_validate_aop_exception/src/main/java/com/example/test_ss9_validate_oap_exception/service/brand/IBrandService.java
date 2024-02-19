package com.example.test_ss9_validate_oap_exception.service.brand;

import com.example.test_ss9_validate_oap_exception.model.Brand;

import java.util.List;

public interface IBrandService {
    List<Brand> findAll();
    Brand findById(int id);
}
