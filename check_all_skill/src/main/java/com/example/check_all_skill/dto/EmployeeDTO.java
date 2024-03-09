package com.example.check_all_skill.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeeDTO implements Validator {

    private int idEm;
    @NotBlank(message = "Bắt buộc phải có tên")
    private String nameEm;
    private int ageEm;
    private double salary;
    private int fkCompany;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int idEm, String nameEm, int ageEm, double salary, int fkCompany) {
        this.idEm = idEm;
        this.nameEm = nameEm;
        this.ageEm = ageEm;
        this.salary = salary;
        this.fkCompany = fkCompany;
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

    public int getFkCompany() {
        return fkCompany;
    }

    public void setFkCompany(int fkCompany) {
        this.fkCompany = fkCompany;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
