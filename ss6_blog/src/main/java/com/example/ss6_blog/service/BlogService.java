package com.example.ss6_blog.service;

import com.example.ss6_blog.model.Blog;
import com.example.ss6_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository repository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Blog read(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void update2(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
