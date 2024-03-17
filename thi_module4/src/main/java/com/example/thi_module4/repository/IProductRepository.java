package com.example.thi_module4.repository;

import com.example.thi_module4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select * from product where name_product like %:name%",nativeQuery = true)
    Page<Product> searchByName(Pageable pageable, @Param("name") String name);


    @Query(value = "select * from product where price = :price",nativeQuery = true)
    Page<Product> searchByPrice(Pageable pageable, @Param("price") double price);

    @Query(value = "select * from product where id_loai_sp = :category" ,nativeQuery = true)
    Page<Product> searchByCate(Pageable pageable, @Param("category") Long category);
//select * from product where name_product like '%tivi%' and price = 123123;
    @Query(value = "select * from product where name_product like %:tivi% and price >   = :price" ,nativeQuery = true)
    Page<Product> searchAll(Pageable pageable,@Param("tivi") String tivi, @Param("price") double price);

}
