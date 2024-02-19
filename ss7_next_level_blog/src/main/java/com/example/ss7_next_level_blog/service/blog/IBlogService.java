package com.example.ss7_next_level_blog.service.blog;

import com.example.ss7_next_level_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    void add(Blog blog);
    Blog read(int id);
    void update(Blog blog);
    void delete(int id);

    Page<Blog> findByTitleContaining(Pageable pageable,String nameSearch);
    Page<Blog> findByContentContaining(Pageable pageable , String nameContent);
    Page<Blog> showListCategoryId(Pageable pageable, int categoryId);
    List<Blog> listBlogQuery(Pageable pageable, int categoryId);

}
