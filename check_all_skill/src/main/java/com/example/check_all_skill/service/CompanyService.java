package com.example.check_all_skill.service;

import com.example.check_all_skill.model.Company;
import com.example.check_all_skill.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService{
    @Autowired
    private ICompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(int id) {
        return companyRepository.findById(id).orElse(null);
    }


}
