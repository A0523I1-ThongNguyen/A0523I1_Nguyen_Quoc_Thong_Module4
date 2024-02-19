package com.example.one_to_many.service;

import com.example.one_to_many.model.Department;
import com.example.one_to_many.model.Employee;

import java.util.List;

public class DepartmentService {
    Department department;

    public List<Employee> showListEmployee(){
        List<Employee> listEmployee = department.getEmployees();
        for (Employee employee : listEmployee) {
            System.out.println(employee.getNameEmployee());
        }
        return listEmployee;
    }

}
