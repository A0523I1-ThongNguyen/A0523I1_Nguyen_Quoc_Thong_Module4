package com.example.springboot1.service.student;

import com.example.springboot1.model.Student;
import com.example.springboot1.repository.student.IStudentRepository;

import java.util.List;

public interface IStudentService {
    List<Student> showList();

    void addNewStudent(Student student);

    void delAll();

    void deleteById(Long id);

    Student findById(Long id);
}
