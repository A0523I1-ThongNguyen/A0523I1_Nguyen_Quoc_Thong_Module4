package com.example.check_all_skill_2.service.School;

import com.example.check_all_skill_2.model.School;
import com.example.check_all_skill_2.model.Student;

import java.util.List;

public interface ISchoolService {
    List<School> findAll();
    School findById(int id);
    void addSchool(School school);
}
