package com.example.test_ss7_car_springdata.service.car;

import com.example.test_ss7_car_springdata.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICarService {
    Page<Car> findAll2(Pageable pageable);
    void add(Car car);
    void delete(Long id);
    Car findById(Long id);
    void update(Car car);
}
