package com.example.demo_aop.service.student;

import com.example.demo_aop.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    //    List<Student> showList();
    Page<Student> findAll(Pageable pageable);

    void addNewStudent(Student student);
    List<Student> findAll();
}
