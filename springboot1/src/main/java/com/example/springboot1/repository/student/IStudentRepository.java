package com.example.springboot1.repository.student;

import com.example.springboot1.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
}
