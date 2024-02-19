package com.example.ss7_check_blog.service.blog;

import com.example.ss7_check_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> listPageBlog(Pageable pageable);
    void add(Blog blog);
}
