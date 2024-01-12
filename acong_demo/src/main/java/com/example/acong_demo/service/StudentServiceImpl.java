package com.example.acong_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.acong_demo.repository.IStudentRepository;
import com.example.acong_demo.repository.StudentRepositoryImpl;

import com.example.acong_demo.model.Student;
import java.util.List;


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