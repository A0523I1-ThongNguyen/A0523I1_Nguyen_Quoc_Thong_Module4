package com.example.demo_thi_t.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLaptop;
    private String nameLaptop;
    private double price;
    @Column(columnDefinition = "text")
    private String description;
    private LocalDate dateOfManufacture;

    @ManyToOne
    @JoinColumn(name = "fk_brand")
    private Brand brand;

    public Laptop() {
    }

    public Laptop(Long idLaptop, String nameLaptop, double price, String description, LocalDate dateOfManufacture, Brand brand) {
        this.idLaptop = idLaptop;
        this.nameLaptop = nameLaptop;
        this.price = price;
        this.description = description;
        this.dateOfManufacture = dateOfManufacture;
        this.brand = brand;
    }

    public Long getIdLaptop() {
        return idLaptop;
    }

    public void setIdLaptop(Long idLaptop) {
        this.idLaptop = idLaptop;
    }

    public String getNameLaptop() {
        return nameLaptop;
    }

    public void setNameLaptop(String nameLaptop) {
        this.nameLaptop = nameLaptop;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
