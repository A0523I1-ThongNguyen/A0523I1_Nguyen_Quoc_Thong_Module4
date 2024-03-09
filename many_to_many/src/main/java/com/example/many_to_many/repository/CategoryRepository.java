package com.example.many_to_many.repository;

import com.example.many_to_many.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
