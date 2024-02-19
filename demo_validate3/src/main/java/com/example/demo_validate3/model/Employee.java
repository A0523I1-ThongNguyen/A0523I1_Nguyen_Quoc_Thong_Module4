package com.example.demo_validate3.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployee;
    private String nameEm;
    private int age;
    private double salary;
    @ManyToOne
    @JoinColumn(name = "kn_department")
    private Department knDepartment;

    public Employee(int idEmployee, String nameEm, int age, double salary) {
        this.idEmployee = idEmployee;
        this.nameEm = nameEm;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEm() {
        return nameEm;
    }

    public void setNameEm(String nameEm) {
        this.nameEm = nameEm;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getKnDepartment() {
        return knDepartment;
    }

    public void setKnDepartment(Department knDepartment) {
        this.knDepartment = knDepartment;
    }
}
