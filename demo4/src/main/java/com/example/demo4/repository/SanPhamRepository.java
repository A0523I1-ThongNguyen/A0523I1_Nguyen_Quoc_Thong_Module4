package com.example.demo4.repository;

import com.example.demo4.model.SanPham;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SanPhamRepository implements ISanPhamRepository {
    private static List<SanPham> listSp;

    static {
        listSp = new ArrayList<>();
        listSp.add(new SanPham(1, "banh", 10000));
        listSp.add(new SanPham(2, "keo", 5000));
        listSp.add(new SanPham(3, "nuoc", 15000));
        listSp.add(new SanPham(4, "xe", 160000000));
    }

    @Override
    public List<SanPham> findAll() {
        return listSp;
    }

    @Override
    public void add(SanPham sanPham) {
        listSp.add(sanPham);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < listSp.size(); i++) {
            if (listSp.get(i).getId() == id) {
                listSp.remove(listSp.get(i));
            }
        }
    }

    @Override
    public SanPham findById(int id) {
        for (int i = 0; i < listSp.size(); i++) {
            if (listSp.get(i).getId() == id) {
                return listSp.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(int id, SanPham sanPhamUpdate) {
        for (int i = 0; i < listSp.size(); i++) {
            if (listSp.get(i).getId() == id) {
               listSp.set(i,sanPhamUpdate);
            }
        }
    }

    @Override
    public List<SanPham> search(String name) {
        List<SanPham> listSanPham = new ArrayList<>();
        for (SanPham sp : listSp){
            if (sp.getName().equals(name)){
                listSanPham.add(sp);
            }
        }
        return listSanPham;
    }

}
