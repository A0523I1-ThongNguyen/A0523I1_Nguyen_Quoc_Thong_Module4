package com.example.check_all_skill_2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
    @Id
    private int idStudent;
    private String nameStudent;
    private String status;
    @ManyToOne
    @JoinColumn(name = "fkSchool")
    private School school;

    public Student() {
    }

    public Student(int idStudent, String nameStudent, String status, School school) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.status = status;
        this.school = school;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

}
