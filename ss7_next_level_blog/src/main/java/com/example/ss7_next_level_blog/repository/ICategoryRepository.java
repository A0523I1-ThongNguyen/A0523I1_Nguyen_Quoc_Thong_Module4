package com.example.ss7_next_level_blog.repository;

import com.example.ss7_next_level_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
//    Page<Category> findAll(Pageable pageable);
}
