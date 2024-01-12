package com.example.orm2.model;

import javax.persistence.*;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private boolean floor;

    @Convert(converter = ConvertLanguages.class)
    private String[] design;

    public House(int id, String name, boolean floor, String[] design) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.design = design;
    }

    public House() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFloor() {
        return floor;
    }

    public void setFloor(boolean floor) {
        this.floor = floor;
    }

    public String[] getDesign() {
        return design;
    }

    public void setDesign(String[] design) {
        this.design = design;
    }
}
