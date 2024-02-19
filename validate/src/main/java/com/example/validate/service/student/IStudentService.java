package com.example.validate.service.student;

import com.example.validate.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    //    List<Student> showList();
    Page<Student> findAll(Pageable pageable);

    void addNewStudent(Student student);
}
