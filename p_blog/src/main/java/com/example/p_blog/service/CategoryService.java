package com.example.p_blog.service;

import com.example.p_blog.model.Category;
import com.example.p_blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> listCategory() {
        return iCategoryRepository.findAll();
    }
}