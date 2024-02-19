package com.example.test_ss7_car_springdata.service.brand;

import com.example.test_ss7_car_springdata.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBrandService {
//    Page<Brand> findAllPage(Pageable pageable);
    List<Brand> findAll();
    void add(Brand brand);
}
