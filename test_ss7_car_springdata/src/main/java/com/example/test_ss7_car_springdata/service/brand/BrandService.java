package com.example.test_ss7_car_springdata.service.brand;

import com.example.test_ss7_car_springdata.model.Brand;
import com.example.test_ss7_car_springdata.repository.brand.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService implements IBrandService{
    @Autowired
    private IBrandRepository iBrandRepository;
//    @Override
//    public Page<Brand> findAllPage(Pageable pageable) {
//        return iBrandRepository.findAllPage(pageable);
//    }

    @Override
    public List<Brand> findAll() {
        return iBrandRepository.findAll();
    }

    @Override
    public void add(Brand brand) {
        iBrandRepository.save(brand);
    }
}
