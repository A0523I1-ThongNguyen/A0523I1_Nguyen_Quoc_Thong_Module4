package com.example.ss7_next_level_blog.service.category;

import com.example.ss7_next_level_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);
    List<Category> showList();
}
