package com.example.demo_thi_t.dto;

import com.example.demo_thi_t.model.Brand;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class LaptopDTO implements Validator {
    private Long idLaptop;
    @NotBlank(message = "Khong duoc de trong")
    private String nameLaptop;
    private double price;

    private String description;
    private LocalDate dateOfManufacture;
    private Brand brand;

    public LaptopDTO() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        LaptopDTO laptopDTO = (LaptopDTO) target;
        if (laptopDTO.getPrice() < 1 || laptopDTO.getPrice() > 999) {
            errors.rejectValue("price", null,"Gia tu 1 den 999");
        }
    }
}
