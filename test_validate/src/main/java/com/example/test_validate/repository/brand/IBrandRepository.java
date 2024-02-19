package com.example.test_validate.repository.brand;

import com.example.test_validate.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBrandRepository extends JpaRepository<Brand,Long> {
}
