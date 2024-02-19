package com.example.test_validate.service.car;

import com.example.test_validate.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICarService {
    void save(Car car);
    void delete(Long id);
    Page<Car> findAll(Pageable pageable);
}
