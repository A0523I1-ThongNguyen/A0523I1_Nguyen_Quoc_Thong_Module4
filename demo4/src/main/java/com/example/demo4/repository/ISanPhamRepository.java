package com.example.demo4.repository;

import com.example.demo4.model.SanPham;

import java.util.List;

public interface ISanPhamRepository {
    List<SanPham> findAll();
    void add(SanPham sanPham);
    void delete(int id);

    SanPham findById(int id);

    void update(int index , SanPham sanPhamUpdate);

    List<SanPham> search(String name);
}
