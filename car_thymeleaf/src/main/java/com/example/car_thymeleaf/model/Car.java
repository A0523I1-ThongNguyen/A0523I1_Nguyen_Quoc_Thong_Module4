package com.example.car_thymeleaf.model;

public class Car {
    private int id;
    private String name;
    private double price;
    private String[] version;
    private boolean sunroof;


    public Car(){

    }

    public Car(int id, String name, double price, String[] version, boolean sunroof) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.version = version;
        this.sunroof = sunroof;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getVersion() {
        return version;
    }

    public void setVersion(String[] version) {
        this.version = version;
    }
    public boolean isSunroof() {
        return sunroof;
    }

    public void setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }

}
