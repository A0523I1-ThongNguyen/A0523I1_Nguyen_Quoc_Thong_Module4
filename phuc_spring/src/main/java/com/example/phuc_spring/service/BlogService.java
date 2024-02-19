package com.example.phuc_spring.service;

import com.example.phuc_spring.model.Blog;
import com.example.phuc_spring.repository.IBlogRepository;
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
    public void update(Blog blog, int id) {
        repository.save(blog);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
