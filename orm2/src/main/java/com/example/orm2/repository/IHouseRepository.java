package com.example.orm2.repository;

import com.example.orm2.model.House;

import java.util.List;

public interface IHouseRepository {
    List<House> findAll();
    void add(House house);
}
