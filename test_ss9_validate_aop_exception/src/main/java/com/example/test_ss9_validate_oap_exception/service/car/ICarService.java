package com.example.test_ss9_validate_oap_exception.service.car;

import com.example.test_ss9_validate_oap_exception.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICarService {
    Page<Car> findAll(Pageable pageable);
    void update(Car car);
    Car findById(int id);
    int randomIdCar();
    void delete(int idCar);
}
