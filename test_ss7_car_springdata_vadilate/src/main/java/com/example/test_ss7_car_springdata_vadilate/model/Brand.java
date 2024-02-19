package com.example.test_ss7_car_springdata_vadilate.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBrand;
    private String nameBrand;
    private String nameManufacture;
    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
    private List<Car> carList;
    public Brand(){

    }

    public Brand(Long idBrand, String nameBrand, String nameManufacture, List<Car> carList) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
        this.nameManufacture = nameManufacture;
        this.carList = carList;
    }

    public Long getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Long idBrand) {
        this.idBrand = idBrand;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getNameManufacture() {
        return nameManufacture;
    }

    public void setNameManufacture(String nameManufacture) {
        this.nameManufacture = nameManufacture;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
