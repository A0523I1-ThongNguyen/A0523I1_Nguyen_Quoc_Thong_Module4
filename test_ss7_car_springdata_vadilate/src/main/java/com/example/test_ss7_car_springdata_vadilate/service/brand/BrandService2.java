package com.example.test_ss7_car_springdata_vadilate.service.brand;

import com.example.test_ss7_car_springdata_vadilate.model.Brand;
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

    @Override
    public Brand findById(Long id) {
        return null;
    }

}
