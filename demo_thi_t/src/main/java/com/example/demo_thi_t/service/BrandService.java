package com.example.demo_thi_t.service;

import com.example.demo_thi_t.model.Brand;
import com.example.demo_thi_t.repository.IBrandRepository;
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
}
