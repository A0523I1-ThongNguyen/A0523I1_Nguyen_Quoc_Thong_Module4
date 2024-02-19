package com.example.test_ss7_car_springdata.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CarDTO implements Validator {
    @NotBlank(message = "Name Car Not Empty!!")
    private String nameCar;
    @NotBlank(message = "Not Empty!!")
    private double price;
    private Long brand;

    public CarDTO() {
    }

    public CarDTO(String nameCar, double price, Long brand) {
        this.nameCar = nameCar;
        this.price = price;
        this.brand = brand;
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

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CarDTO carDTO = (CarDTO) target;
        if (carDTO.getNameCar().equals("")) {
            errors.rejectValue("nameCar", null, "Khong duoc rong nghe !");
        } else if (!carDTO.getNameCar().matches("^[a-zA-Z0-9\\s\\u00C0-\\u1EF9]*$")) {
            errors.rejectValue("nameCar",null,"Không được chứa các kí tự đặc biệt");
        }
        if (carDTO.getPrice() == 10000 || carDTO.getPrice() < 0){
            errors.rejectValue("price",null,"0 đủ tiền & không được vượ quá 10000 tỷ");
        }

    }
}
