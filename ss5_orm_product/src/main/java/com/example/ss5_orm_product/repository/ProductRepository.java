package com.example.ss5_orm_product.repository;

import com.example.ss5_orm_product.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        String sql = "select p from Product p";
        TypedQuery<Product> query = entityManager.createQuery(sql,Product.class);
        List<Product> listProduct = query.getResultList();
        return listProduct;
    }

    @Override
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public void delete(int id) {
        Product productDel = findById(id);
        entityManager.remove(productDel);
    }

    @Override
    public void update(Product newProduct, Product productUp) {
        BeanUtils.copyProperties(newProduct,productUp);
        entityManager.merge(productUp);
    }
}
