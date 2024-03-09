package com.example.check_all_skill_2.service.Student;

import com.example.check_all_skill_2.model.Student;
import com.example.check_all_skill_2.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSerivce implements IStudentService{
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }
    @Override
    public void add(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        iStudentRepository.deleteById(id);
    }

}
