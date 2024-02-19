package com.example.demo_validate.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStudent;
    private String nameStudent;
    @ManyToOne
    @JoinColumn(name="kn_floor")
    private Floor knFloor; // biến knFloor đại diện cho bảng Floor lấy ra nameFloor.

    public Student() {
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

    public Floor getKnFloor() {
        return knFloor;
    }

    public void setKnFloor(Floor knFloor) {
        this.knFloor = knFloor;
    }
}
