package com.example.check_all_skill.service;

import com.example.check_all_skill.model.Employee;
import com.example.check_all_skill.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> searchByName(Pageable pageable, String nameEm) {
        return employeeRepository.searchByName(pageable,nameEm);
    }

    @Override
    public List<Employee> searchByName2(String nameEm) {
        return employeeRepository.searchByName2(nameEm);
    }

    @Override
    public List<Employee> searchByCompany(int idCompany) {
        return employeeRepository.searchByCompany(idCompany);
    }

}
