package com.example.ss7_check_blog.service.blog;

import com.example.ss7_check_blog.model.Blog;
import com.example.ss7_check_blog.repository.blog.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository repository;

    @Override
    public Page<Blog> listPageBlog(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Blog blog) {
        repository.save(blog);
    }
}
