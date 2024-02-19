package com.example.demo6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Floor {
    @Id
    private int idFloor;
    private String nameFloor;

    public Floor() {
    }

    public int getIdFloor() {
        return idFloor;
    }

    public void setIdFloor(int idFloor) {
        this.idFloor = idFloor;
    }

    public String getNameFloor() {
        return nameFloor;
    }

    public void setNameFloor(String nameFloor) {
        this.nameFloor = nameFloor;
    }
}
