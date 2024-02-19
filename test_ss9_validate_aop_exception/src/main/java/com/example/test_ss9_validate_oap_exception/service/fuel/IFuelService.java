package com.example.test_ss9_validate_oap_exception.service.fuel;

import com.example.test_ss9_validate_oap_exception.model.Brand;
import com.example.test_ss9_validate_oap_exception.model.Fuel;

import java.util.List;

public interface IFuelService {
    List<Fuel> findAll();
    Fuel findById(int id);
    void update(Fuel fuel);
}
