package com.example.demo_validate3.service.employee;

import com.example.demo_validate3.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void save(Employee employee);
}
