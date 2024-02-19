package com.example.ss7_next_level_blog.service.blog;

import com.example.ss7_next_level_blog.model.Blog;
import com.example.ss7_next_level_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public void add(Blog blog) {
            iBlogRepository.save(blog);
    }

    @Override
    public Blog read(int id)     {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByTitleContaining(Pageable pageable, String nameSearch) {
        return iBlogRepository.findByTitleContaining(pageable,nameSearch);
    }

    @Override
    public Page<Blog> findByContentContaining(Pageable pageable, String nameContent) {
        return iBlogRepository.findByContentContaining(pageable,nameContent);
    }

    @Override
    public Page<Blog> showListCategoryId(Pageable pageable, int categoryId) {
        return iBlogRepository.showListCategoryId(pageable,categoryId);
    }
    @Override
    public List<Blog> listBlogQuery(Pageable pageable, int categoryId) {
        return iBlogRepository.listBlogQuery(pageable,categoryId);
    }
}
