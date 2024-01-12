package com.example.acong_demo.service;



import com.example.acong_demo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
