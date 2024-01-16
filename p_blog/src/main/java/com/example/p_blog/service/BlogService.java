package com.example.p_blog.service;

import com.example.p_blog.model.Blog;
import com.example.p_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable, String searchTitle) {
        return iBlogRepository.findByTitleContaining(pageable,searchTitle);
    }

    @Override
    public void add(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog read(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog, int id) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> showListCategoryOfBlog(Pageable pageable, int categoryOfBlog) {
        return iBlogRepository.showListCategoryId(pageable,categoryOfBlog);
    }
}
