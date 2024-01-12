package com.example.orm_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.orm_demo.model.Student;
import com.example.orm_demo.repository.IStudentRepository;
import com.example.orm_demo.repository.StudentRepositoryImpl;

import java.util.List;

/**
 * (C) Copyright 2023 iHub Academy. All Rights Reserved.
 *
 * @author TrungDC
 * @version 1.0
 * @since 12/27/2023
 */
@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private IStudentRepository repository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public List<Student> findByName(String keyword) {
        return null;
    }
}