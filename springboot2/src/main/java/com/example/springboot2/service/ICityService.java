package com.example.springboot2.service;

import com.example.springboot2.model.City;
import com.example.springboot2.model.Nation;

import java.util.List;

public interface ICityService {
    List<City> findAll();
}
