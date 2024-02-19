package com.example.test_ss7_car_springdata.service.brand;

import com.example.test_ss7_car_springdata.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService2 implements IBrandService{
    @Override
    public List<Brand> findAll() {
        return null;
    }

    @Override
    public void add(Brand brand) {
        System.out.println("zz");
    }
}
