package com.example.ss7_next_level_blog.service.category;

import com.example.ss7_next_level_blog.model.Category;
import com.example.ss7_next_level_blog.repository.IBlogRepository;
import com.example.ss7_next_level_blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository repository;
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Category> showList() {
            return repository.findAll();
    }

}
