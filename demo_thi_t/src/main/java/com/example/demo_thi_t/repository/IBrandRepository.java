package com.example.demo_thi_t.repository;

import com.example.demo_thi_t.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBrandRepository extends JpaRepository<Brand,Long> {

}
