package com.example.check_all_skill_2.repository;

import com.example.check_all_skill_2.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
    Page<Student> findAll(Pageable pageable);
}
