package com.example.demo4.service;

import com.example.demo4.model.SanPham;

import java.util.List;

public interface ISanPhamService {
    List<SanPham> findAll();
    void add(SanPham sanPham);

    void delete(int id);
    SanPham findById(int id);
    void update(int id, SanPham sanPhamUpdate);
    List<SanPham> search(String name);
}
