package com.example.one_to_many.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartment;
    private String nameDepartment;
    @OneToMany(mappedBy = "kn_of_department")
    private List<Employee> employees;

    public Department() {
    }

    public Department(int idDepartment, String nameDepartment, List<Employee> employees) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
        this.employees = employees;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
