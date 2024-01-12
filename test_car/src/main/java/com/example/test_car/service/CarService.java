package com.example.test_car.service;

import com.example.test_car.model.Car;
import com.example.test_car.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {

    @Autowired
    private ICarRepository repository;

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Car car) {
        repository.add(car);
    }

    @Override
    public void remove(Car car) {
        repository.remove(car);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
