package com.example.car_thymeleaf.repository;

import com.example.car_thymeleaf.model.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> findAll();
    void delete (int id);
}
