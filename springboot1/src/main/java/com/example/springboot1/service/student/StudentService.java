package com.example.springboot1.service.student;

import com.example.springboot1.model.Student;
import com.example.springboot1.repository.student.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> showList() {
        return iStudentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
        iStudentRepository.save(student);
    }


    @Override
    public void delAll() {
        iStudentRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id ) {
        iStudentRepository.deleteById(id);
    }


    @Override
    public Student findById(Long id) {
        return iStudentRepository.findById(id).orElse(null);
    }
}
