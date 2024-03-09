package com.example.check_all_skill.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Company {
    @Id
    private int idCompany;
    private String nameCompany;

    @OneToMany(mappedBy = "company")
    private List<Employee> listEmployeeOfCompany;
    public Company() {
    }
    public Company(int idCompany, String nameCompany, List<Employee> listEmployeeOfCompany) {
        this.idCompany = idCompany;
        this.nameCompany = nameCompany;
        this.listEmployeeOfCompany = listEmployeeOfCompany;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public List<Employee> getListEmployeeOfCompany() {
        return listEmployeeOfCompany;
    }

    public void setListEmployeeOfCompany(List<Employee> listEmployeeOfCompany) {
        this.listEmployeeOfCompany = listEmployeeOfCompany;
    }
}
