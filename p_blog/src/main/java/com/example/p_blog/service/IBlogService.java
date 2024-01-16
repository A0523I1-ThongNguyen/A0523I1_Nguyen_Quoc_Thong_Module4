package com.example.p_blog.service;

import com.example.p_blog.model.Blog;
import com.example.p_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable,String searchTitle);

    void add(Blog blog);

    Blog read(int id);

    void update(Blog blog, int id);

    void delete(int id);
    Page<Blog> showListCategoryOfBlog(Pageable pageable,int categoryOfBlog);
}