package com.example.test_ss9_validate_oap_exception.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Fuel {
    @Id
    private int idFuel;
    private String typeFuel;

    private int quantityFuel;
    @OneToMany(mappedBy = "fuelCar")
    private List<Car> listCarFuel;

    public Fuel() {
    }

    public Fuel(int idFuel, String typeFuel, List<Car> listCarFuel) {
        this.idFuel = idFuel;
        this.typeFuel = typeFuel;
        this.listCarFuel = listCarFuel;
    }

    public int getIdFuel() {
        return idFuel;
    }

    public void setIdFuel(int idFuel) {
        this.idFuel = idFuel;
    }

    public String getTypeFuel() {
        return typeFuel;
    }

    public void setTypeFuel(String typeFuel) {
        this.typeFuel = typeFuel;
    }

    public int getQuantityFuel() {
        return quantityFuel;
    }

    public void setQuantityFuel(int quantityFuel) {
        this.quantityFuel = quantityFuel;
    }

    public List<Car> getListCarFuel() {
        return listCarFuel;
    }

    public void setListCarFuel(List<Car> listCarFuel) {
        this.listCarFuel = listCarFuel;
    }
}
