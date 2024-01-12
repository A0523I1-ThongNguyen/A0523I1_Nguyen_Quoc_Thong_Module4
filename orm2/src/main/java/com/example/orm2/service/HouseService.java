package com.example.orm2.service;

import com.example.orm2.model.House;
import com.example.orm2.repository.HouseRepository;
import com.example.orm2.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService implements IHouserService{
    @Autowired
    private IHouseRepository houseRepository;
    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public void add(House house) {
        houseRepository.add(house);
    }
}
