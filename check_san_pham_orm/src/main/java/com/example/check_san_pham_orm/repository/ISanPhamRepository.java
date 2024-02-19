package com.example.check_san_pham_orm.repository;

import com.example.check_san_pham_orm.model.SanPham;

import java.util.List;

public interface ISanPhamRepository {
    List<SanPham> findAll();
    void save(SanPham sanPham);
    SanPham findById(int id);
    void update(SanPham sanPham , int id);
    void delete(int id);
}
