package com.example.many_many.repository;

import com.example.many_many.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT p.* FROM product p JOIN product_category pc ON p.id = pc.product_id JOIN category c ON pc.category_id = c.id WHERE c.id = :categoryId", nativeQuery = true)
    List<Product> findByCategoryId(@Param("categoryId") Long categoryId);


    @Query(value = "SELECT p.* FROM product p JOIN product_category pc ON p.id = pc.product_id JOIN category c ON pc.category_id = c.id", nativeQuery = true)
    List<Product> findByCategoryId2();
}
