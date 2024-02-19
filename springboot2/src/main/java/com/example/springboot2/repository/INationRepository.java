package com.example.springboot2.repository;

import com.example.springboot2.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INationRepository extends JpaRepository<Nation,Integer> {
}
