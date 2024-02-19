package com.example.test_ss7_car_springdata_vadilate.service.brand;

import com.example.test_ss7_car_springdata_vadilate.model.Brand;

import java.util.List;

public interface IBrandService {
//    Page<Brand> findAllPage(Pageable pageable);
    List<Brand> findAll();
    void add(Brand brand);
    Brand findById(Long id);
}
