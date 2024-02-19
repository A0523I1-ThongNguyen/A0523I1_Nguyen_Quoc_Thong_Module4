package com.example.demo6.model;

import jakarta.validation.constraints.NotBlank;

public class StudentDTO {
    @NotBlank(message = "No empty")
    private String name;
    private int knFloor;

    public StudentDTO() {
    }

    public StudentDTO(String name, int knFloor) {
        this.name = name;
        this.knFloor = knFloor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKnFloor() {
        return knFloor;
    }

    public void setKnFloor(int knFloor) {
        this.knFloor = knFloor;
    }
}
