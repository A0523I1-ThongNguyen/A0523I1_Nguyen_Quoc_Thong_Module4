package com.example.test_ss9_validate_oap_exception.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBrand;
    private String nameBrand;
    @OneToMany(mappedBy = "brandCar")
    private List<Car> listCarBrand;

    public Brand() {
    }

    public Brand(int idBrand, String nameBrand, List<Car> listCar) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
        this.listCarBrand = listCar;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public List<Car> getListCar() {
        return listCarBrand;
    }

    public void setListCar(List<Car> listCar) {
        this.listCarBrand = listCar;
    }
}
