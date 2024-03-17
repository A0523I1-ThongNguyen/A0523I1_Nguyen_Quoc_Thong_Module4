package com.example.demo_thi_t.repository;

import com.example.demo_thi_t.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILaptopRepository extends JpaRepository<Laptop,Long> {
}
