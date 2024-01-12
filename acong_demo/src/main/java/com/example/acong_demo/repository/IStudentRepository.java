package com.example.acong_demo.repository;

import com.example.acong_demo.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
