package com.example.one_to_many.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployee;
    private String nameEmployee;
    private double salary;
    @ManyToOne
    @JoinColumn(name = "hehe")
    private Department kn_of_department;

    public Employee() {
    }

    public Employee(int idEmployee, String nameEmployee, double salary) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.salary = salary;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
