package com.example.check_all_skill.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEm;
    private String nameEm;
    private int ageEm;
    private double salary;

    @ManyToOne
//Điều này có nghĩa là trong cơ sở dữ liệu, bảng Employee sẽ có một cột "fkCompany" để lưu giá trị khóa ngoại tới bảng Company.
    @JoinColumn(name = "fkCompany")
    private Company company; // mỗi Employee sẽ có một trường Company để đại diện cho công ty mà nhân viên đó thuộc về.

    public Employee(int idEm, String nameEm, int ageEm, double salary, Company company) {
        this.idEm = idEm;
        this.nameEm = nameEm;
        this.ageEm = ageEm;
        this.salary = salary;
        this.company = company;
    }

    public Employee() {
    }

    public int getIdEm() {
        return idEm;
    }

    public void setIdEm(int idEm) {
        this.idEm = idEm;
    }

    public String getNameEm() {
        return nameEm;
    }

    public void setNameEm(String nameEm) {
        this.nameEm = nameEm;
    }

    public int getAgeEm() {
        return ageEm;
    }

    public void setAgeEm(int ageEm) {
        this.ageEm = ageEm;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
