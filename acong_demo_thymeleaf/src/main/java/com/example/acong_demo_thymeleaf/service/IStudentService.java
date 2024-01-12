package com.example.acong_demo_thymeleaf.service;

import com.example.acong_demo_thymeleaf.model.Student;
import com.example.acong_demo_thymeleaf.service.IStudentService;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
