package com.example.test_ss7_car_springdata_vadilate.service.car;

import com.example.test_ss7_car_springdata_vadilate.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICarService {
    Page<Car> findAll2(Pageable pageable);
    void add(Car car);
    void delete(Long id);
    Car findById(Long id);
    void update(Car car);
    List<Car> listSearchcar(@Param("name_car") String nameCar);
    Page<Car> listSearchcar2(Pageable pageable,String nameCar);
}
