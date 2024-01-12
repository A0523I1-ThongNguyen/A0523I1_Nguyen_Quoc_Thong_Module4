package com.example.car_thymeleaf.service;

import com.example.car_thymeleaf.model.Car;
import com.example.car_thymeleaf.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService{
    @Autowired
    ICarRepository repository;
    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
