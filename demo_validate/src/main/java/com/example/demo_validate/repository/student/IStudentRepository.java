package com.example.demo_validate.repository.student;

import com.example.demo_validate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
}
