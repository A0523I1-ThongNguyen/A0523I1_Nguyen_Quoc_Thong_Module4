package com.example.demo_aop.repository.student;

import com.example.demo_aop.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Long> {
    Page<Student> findAll(Pageable pageable);
    List<Student> getStudentList();
    List<Student> findAll();
}
