package com.example.springboot2.model;

import jakarta.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int soDan;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="nation_id")
    private Nation nation;

    public City() {
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

    public int getSoDan() {
        return soDan;
    }

    public void setSoDan(int soDan) {
        this.soDan = soDan;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}
