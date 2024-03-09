package com.example.check_all_skill_2.service.School;

import com.example.check_all_skill_2.model.School;
import com.example.check_all_skill_2.model.Student;
import com.example.check_all_skill_2.repository.ISchoolRepotisory;
import com.example.check_all_skill_2.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService implements ISchoolService {
    @Autowired
    private ISchoolRepotisory iSchoolRepotisory;
    @Override
    public List<School> findAll() {
        return iSchoolRepotisory.findAll();
    }

    @Override
    public School findById(int id) {
        return iSchoolRepotisory.findById(id).orElse(null);
    }

    @Override
    public void addSchool(School school) {
        iSchoolRepotisory.save(school);
    }
}
