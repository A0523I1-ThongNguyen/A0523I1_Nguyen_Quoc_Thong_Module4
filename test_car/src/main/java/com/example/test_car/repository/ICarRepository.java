package com.example.test_car.repository;

import com.example.test_car.model.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> findAll();
    void add(Car car);
    void remove(Car id);
    void delete(int id);
}
