package com.example.test_ss9_validate_oap_exception.service.fuel;

import com.example.test_ss9_validate_oap_exception.model.Brand;
import com.example.test_ss9_validate_oap_exception.model.Fuel;
import com.example.test_ss9_validate_oap_exception.repository.fuel.IFuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelService implements IFuelService{
    @Autowired
    private IFuelRepository iFuelRepository;
    @Override
    public List<Fuel> findAll() {
        return iFuelRepository.findAll();
    }

    @Override
    public Fuel findById(int id) {
        return iFuelRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Fuel fuel) {
        iFuelRepository.save(fuel);
    }
}
