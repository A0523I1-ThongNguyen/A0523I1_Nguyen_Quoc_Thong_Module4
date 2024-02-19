package com.example.test_ss9_validate_oap_exception.model;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    private int idCar;
    private int maGuixe;
    private String  NameCar;
    private  double price;
    private int gasoline;
    private String image;
    @ManyToOne
    @JoinColumn(name = "fk_brand")
    private Brand brandCar;

    @ManyToOne
    @JoinColumn(name = "fk_fuel")
    private Fuel fuelCar;

    public Car() {
    }


    public Car(int idCar, int maGuixe, String nameCar, double price, int gasoline, String image, Brand brandCar, Fuel fuelCar) {
        this.idCar = idCar;
        this.maGuixe = maGuixe;
        NameCar = nameCar;
        this.price = price;
        this.gasoline = gasoline;
        this.image = image;
        this.brandCar = brandCar;
        this.fuelCar = fuelCar;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getMaGuixe() {
        return maGuixe;
    }

    public void setMaGuixe(int maGuixe) {
        this.maGuixe = maGuixe;
    }

    public String getNameCar() {
        return NameCar;
    }

    public void setNameCar(String nameCar) {
        NameCar = nameCar;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGasoline() {
        return gasoline;
    }

    public void setGasoline(int gasoline) {
        this.gasoline = gasoline;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Brand getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(Brand brandCar) {
        this.brandCar = brandCar;
    }

    public Fuel getFuelCar() {
        return fuelCar;
    }

    public void setFuelCar(Fuel fuelCar) {
        this.fuelCar = fuelCar;
    }
}
