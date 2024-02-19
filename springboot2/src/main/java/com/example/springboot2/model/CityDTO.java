package com.example.springboot2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CityDTO implements Validator {
    @NotBlank(message = "cannot be blank")
    @Size(min = 2 , message = ">2 character ")
    @Size(max = 10, message = "< 10 character")
    @Pattern(regexp = "^[a-z ]*$", message = "Cannot write uppercase letters + numbers")
    private String name;
    private int soDan;
    private int nation;

    public CityDTO() {
    }

    public CityDTO(String name, int soDan, int nation) {
        this.name = name;
        this.soDan = soDan;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoDan() {
        return soDan;
    }

    public void setSoDan(int soDan) {
        this.soDan = soDan;
    }

    public int getNation() {
        return nation;
    }

    public void setNation(int nation) {
        this.nation = nation;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
