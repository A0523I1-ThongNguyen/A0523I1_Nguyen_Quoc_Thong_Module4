package com.example.spring2.repository.student;

import com.example.spring2.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
        Page<Student> findAll(Pageable pageable);
//        Page<T> findAll(Pageable pageable);
}
