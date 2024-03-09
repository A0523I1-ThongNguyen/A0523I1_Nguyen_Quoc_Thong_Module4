package com.example.check_all_skill.service;

import com.example.check_all_skill.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void create(Employee employee);
    void update(Employee employee);
    Employee findById(int id);
    void delete(int id);
    Page<Employee> searchByName(Pageable pageable,String nameEm);
    List<Employee> searchByName2(@Param("nameEm") String nameEm);

    List<Employee> searchByCompany(int id);
}
