package com.example.check_san_pham_orm.service;

import com.example.check_san_pham_orm.model.SanPham;
import com.example.check_san_pham_orm.repository.ISanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SanPhamService implements ISanPhamService{
    @Autowired
    private ISanPhamRepository sanPhamRepository;
    @Override
    public List<SanPham> findAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public void save(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham findById(int id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public void update(SanPham sanPham, int id) {
        sanPhamRepository.update(sanPham,id);
    }

    @Override
    public void delete(int id) {
        sanPhamRepository.delete(id);
    }
}
