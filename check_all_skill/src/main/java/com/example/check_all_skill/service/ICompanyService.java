package com.example.check_all_skill.service;

import com.example.check_all_skill.model.Company;
import com.example.check_all_skill.model.Employee;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompanyService {
    List<Company> findAll();
    Company findById(int id);

}
