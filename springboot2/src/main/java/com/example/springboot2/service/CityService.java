package com.example.springboot2.service;

import com.example.springboot2.model.City;
import com.example.springboot2.model.Nation;
import com.example.springboot2.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService{
    @Autowired
    ICityRepository repostory ;

    @Override
    public List<City> findAll() {
        return repostory.findAll();
    }
}
