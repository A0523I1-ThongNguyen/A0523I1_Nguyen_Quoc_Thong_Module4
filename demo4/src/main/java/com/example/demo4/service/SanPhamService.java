package com.example.demo4.service;

import com.example.demo4.model.SanPham;
import com.example.demo4.repository.ISanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService implements ISanPhamService{
    @Autowired
    private ISanPhamRepository repository;
    @Override
    public List<SanPham> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(SanPham sanPham) {
        repository.add(sanPham);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public SanPham findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(int id, SanPham sanPhamUpdate) {
        repository.update(id,sanPhamUpdate);
    }

    @Override
    public List<SanPham> search(String name) {
        return repository.search(name);
    }


}
