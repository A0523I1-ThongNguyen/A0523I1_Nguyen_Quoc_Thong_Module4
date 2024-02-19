package com.example.test_validate.model;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCar;
    private String nameCar;
    private double price;

    @ManyToOne
    @JoinColumn(name = "kn_id_brand")
    private Brand knIdBrand;

    public Car() {
    }

    public Car(int idCar, String nameCar, double price, Brand knIdBrand) {
        this.idCar = idCar;
        this.nameCar = nameCar;
        this.price = price;
        this.knIdBrand = knIdBrand;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getKnIdBrand() {
        return knIdBrand;
    }

    public void setKnIdBrand(Brand knIdBrand) {
        this.knIdBrand = knIdBrand;
    }
}
