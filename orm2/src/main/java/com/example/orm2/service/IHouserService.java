package com.example.orm2.service;

import com.example.orm2.model.House;

import java.util.List;

public interface IHouserService {
    List<House> findAll();
    void add(House house);
}
