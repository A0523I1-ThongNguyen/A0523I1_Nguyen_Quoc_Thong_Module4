package com.example.car_thymeleaf.service;

import com.example.car_thymeleaf.model.Car;

import java.util.List;

public interface ICarService {
    List<Car> findAll();
    void delete (int id);
}
