package com.example.test_ss7_car_springdata_vadilate.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CarDTO implements Validator {
    private Long idCar;
    @NotBlank(message = "Name Car Not Empty!!")
    private String nameCar;

    private double price;
    private Long knBrand;

    public CarDTO() {
    }

    public CarDTO(Long idCar, String nameCar, double price, Long knBrand) {
        this.idCar = idCar;
        this.nameCar = nameCar;
        this.price = price;
        this.knBrand = knBrand;
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
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

    public Long getKnBrand() {
        return knBrand;
    }

    public void setKnBrand(Long knBrand) {
        this.knBrand = knBrand;
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
            errors.rejectValue("nameCar", null, "Không được chứa các kí tự đặc biệt");
        }
        if (carDTO.getPrice() >= 100000 || carDTO.getPrice() <= 0) {
            errors.rejectValue("price", "", "0 đủ tiền & không được vượ quá 10000 tỷ");
        }

    }
}
