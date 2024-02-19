package com.example.test_ss7_car_springdata_vadilate.model;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCar;
    private String nameCar;
    private double price;

    @ManyToOne
    @JoinColumn(name = "kn_brand")
    private Brand brand;

    public Car() {
    }

    public Car(Long idCar, String nameCar, double price, Brand brand) {
        this.idCar = idCar;
        this.nameCar = nameCar;
        this.price = price;
        this.brand = brand;
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
