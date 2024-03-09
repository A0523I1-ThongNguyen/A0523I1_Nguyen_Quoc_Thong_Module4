package com.example.check_all_skill.repository;

import com.example.check_all_skill.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company,Integer> {
}
