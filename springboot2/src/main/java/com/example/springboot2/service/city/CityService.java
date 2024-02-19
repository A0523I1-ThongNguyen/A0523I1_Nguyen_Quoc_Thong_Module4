package com.example.springboot2.service.city;

import com.example.springboot2.model.City;
import com.example.springboot2.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {
    @Autowired
    ICityRepository repostory ;

    @Override
    public List<City> findAll() {
        return repostory.findAll();
    }

    @Override
    public void add(City city) {
        repostory.save(city);
    }

    @Override
    public void deleteById(Integer id) {
        repostory.deleteById(id);
    }

}
