package com.example.check_san_pham_orm.repository;

import com.example.check_san_pham_orm.model.SanPham;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class SanPhamRepository implements ISanPhamRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<SanPham> findAll() {
        String sql = "select s from SanPham s";
        TypedQuery<SanPham> listSanPham = entityManager.createQuery(sql, SanPham.class);
        return listSanPham.getResultList();
    }

    @Override
    public void save(SanPham sanPham) {
        entityManager.persist(sanPham);
    }

    @Override
    public SanPham findById(int id) {
        return entityManager.find(SanPham.class,id);
    }

    @Override
    public void update(SanPham sanPham, int id) {
        BeanUtils.copyProperties(sanPham,sanPham.getId());
        entityManager.merge(sanPham);
    }

    @Override
    public void delete(int id) {
        SanPham sanPham = findById(id);
        entityManager.remove(sanPham);
    }


}
