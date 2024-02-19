package com.example.springboot2.service.nation;

import com.example.springboot2.model.Nation;
import com.example.springboot2.repository.INationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService implements INationSercive{
    @Autowired
    private INationRepository iNationRepository;
    @Override
    public List<Nation> findAll() {
        return iNationRepository.findAll();
    }

    @Override
    public Nation findById(int id) {
        return iNationRepository.findById(id).orElse(null);
    }
}
