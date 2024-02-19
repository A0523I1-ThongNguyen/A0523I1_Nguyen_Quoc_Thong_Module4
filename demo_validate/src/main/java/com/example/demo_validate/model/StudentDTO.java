package com.example.demo_validate.model;

import jakarta.validation.constraints.NotBlank;

public class StudentDTO {
    @NotBlank(message = "No empty")
    private String nameStudent;
    private int knFloor;

    public StudentDTO() {
    }

    public StudentDTO(String nameStudent, int knFloor) {
        this.nameStudent = nameStudent;
        this.knFloor = knFloor;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getKnFloor() {
        return knFloor;
    }

    public void setKnFloor(int knFloor) {
        this.knFloor = knFloor;
    }
}
