package com.example.demo_validate3.service.department;

import com.example.demo_validate3.model.Department;

import java.util.List;

public interface IDepartmentService {
        List<Department> findAll();
        Department findById(int id);
}
