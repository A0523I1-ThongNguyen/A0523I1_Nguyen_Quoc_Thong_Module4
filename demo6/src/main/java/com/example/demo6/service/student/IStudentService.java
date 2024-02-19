package com.example.demo6.service.student;

import com.example.demo6.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
    Page<Student> findAll(Pageable pageable);
    void save(Student student);
}
