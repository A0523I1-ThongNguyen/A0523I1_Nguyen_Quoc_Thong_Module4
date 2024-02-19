package com.example.phuc_spring.service;

import com.example.phuc_spring.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void add(Blog blog);

    Blog read(int id);
    void update(Blog blog, int id);
    void delete(int id);
}
