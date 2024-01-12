package com.example.orm1.service;

import com.example.orm1.model.Student;
import com.example.orm1.service.IStudentService;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
