package com.example.springboot2.service.nation;

import com.example.springboot2.model.Nation;

import java.util.List;

public interface INationSercive {
    List<Nation> findAll();
    Nation findById(int id);
}
