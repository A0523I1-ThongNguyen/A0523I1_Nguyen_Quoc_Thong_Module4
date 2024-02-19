package com.example.test_ss7_car_springdata_vadilate.service.brand;

import com.example.test_ss7_car_springdata_vadilate.model.Brand;
import com.example.test_ss7_car_springdata_vadilate.repository.brand.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Brand findById(Long id) {
        return iBrandRepository.findById(id).orElse(null);
    }
}
