package com.example.demo_thi_t.service;

import com.example.demo_thi_t.model.Laptop;
import com.example.demo_thi_t.repository.ILaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService implements ILaptopService{
    @Autowired
    private ILaptopRepository iLaptopRepository;
    @Override
    public Page<Laptop> findAll(Pageable pageable) {
        return iLaptopRepository.findAll(pageable);
    }

    @Override
    public void add(Laptop laptop) {
        iLaptopRepository.save(laptop);
    }

    @Override
    public void update(Laptop laptop) {
        iLaptopRepository.save(laptop);
    }

    @Override
    public void delete(Long idLaptop) {
        iLaptopRepository.deleteById(idLaptop);
    }

    @Override
    public Laptop findById(Long idLaptop) {
        return iLaptopRepository.findById(idLaptop).orElse(null);
    }

    @Override
    public List<Laptop> findAll() {
        return iLaptopRepository.findAll();
    }
}
