package com.example.test_validate.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CarDTO implements Validator {
    @NotBlank(message = "No Black , ok?")
    private String nameCar;
    private double price;
    private Long knIdBrand;

    public CarDTO() {
    }

    public CarDTO(String nameCar, double price, Long knIdBrand) {
        this.nameCar = nameCar;
        this.price = price;
        this.knIdBrand = knIdBrand;
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

    public Long getKnIdBrand() {
        return knIdBrand;
    }

    public void setKnIdBrand(Long knIdBrand) {
        this.knIdBrand = knIdBrand;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CarDTO carDTO = (CarDTO) target;
        if (carDTO.price > 100){
            errors.rejectValue("price","","not > 1milion");
        } else if (carDTO.price < 15) {
            errors.rejectValue("price","","sua vat met");
        }
    }
}
