package com.example.spring2.service.student;

import com.example.spring2.model.Student;
import com.example.spring2.repository.student.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;

//    @Override
//    public List<Student> showList() {
//        return iStudentRepository.findAll();
//    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }



    @Override
    public void addNewStudent(Student student) {
        iStudentRepository.save(student);
    }
}
