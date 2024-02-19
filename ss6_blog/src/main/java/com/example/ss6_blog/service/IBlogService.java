package com.example.ss6_blog.service;

import com.example.ss6_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void add(Blog blog);

    Blog read(int id);
    void update(Blog blog);
    void update2(Blog blog);
    void delete(int id);
}
