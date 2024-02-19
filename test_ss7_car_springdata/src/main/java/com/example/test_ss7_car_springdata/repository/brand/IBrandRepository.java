package com.example.test_ss7_car_springdata.repository.brand;

import com.example.test_ss7_car_springdata.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<Brand,Long> {
    Page<Brand> findAll(Pageable pageable);
}
