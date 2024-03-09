package com.example.check_all_skill_2.service.Student;

import com.example.check_all_skill_2.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> findAll(Pageable pageable);
    void add(Student student);
    void delete(int id);
}
