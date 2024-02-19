package com.example.ss7_check_blog.service.style;

import com.example.ss7_check_blog.model.Style;
import com.example.ss7_check_blog.repository.style.IStyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleService implements IStyleService{
    @Autowired
    private IStyleRepository repository;
    @Override
    public List<Style> getList() {
        return repository.findAll();
    }
}
