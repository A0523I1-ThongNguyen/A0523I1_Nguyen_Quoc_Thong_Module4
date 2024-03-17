package com.example.demo_thi_t.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBrand;
    private String nameBrand;
    private String made;

    public Brand() {
    }

    @OneToMany(mappedBy = "brand")
    private List<Laptop> listLaptop;


    public Brand(Long idBrand, String nameBrand, String made) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
        this.made = made;
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

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }
}
