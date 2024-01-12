package com.example.orm1.repository;

import com.example.orm1.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
