package com.example.test_ss9_validate_oap_exception.service.brand;

import com.example.test_ss9_validate_oap_exception.model.Brand;
import com.example.test_ss9_validate_oap_exception.repository.brand.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private IBrandRepository iBrandRepository;

    @Override
    public List<Brand> findAll() {
        return iBrandRepository.findAll();
    }

    @Override
    public Brand findById(int id) {
        return iBrandRepository.findById(id).orElse(null);
    }
}
