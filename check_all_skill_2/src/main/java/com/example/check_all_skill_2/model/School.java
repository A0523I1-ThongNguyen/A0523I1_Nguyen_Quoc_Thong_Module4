package com.example.check_all_skill_2.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSchool;
    private String nameSchool;
    @OneToMany(mappedBy = "school")
    private List<Student> studentList;

    public School() {
    }

    public School(int idSchool, String nameSchool) {
        this.idSchool = idSchool;
        this.nameSchool = nameSchool;
    }

    public int getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(int idSchool) {
        this.idSchool = idSchool;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
