package com.example.test_ss9_validate_oap_exception.dto;

import com.example.test_ss9_validate_oap_exception.model.Brand;
import com.example.test_ss9_validate_oap_exception.model.Fuel;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CarDTO implements Validator {
    private int idCar;
    private int maGuixe;
    @NotBlank(message = "Bắt buộc phải có tên")
    @Size(min = 2, message = "< 10 character")
    private String  nameCar;
    private  double price;
    private int gasoline;
    private String image;
    private int fkBrandCar;
    private int fkFuelCar;

    public CarDTO() {
    }

    public CarDTO(int idCar, int maGuixe, String nameCar, double price, int gasoline, String image, int fkBrandCar, int fkFuelCar) {
        this.idCar = idCar;
        this.maGuixe = maGuixe;
        this.nameCar = nameCar;
        this.price = price;
        this.gasoline = gasoline;
        this.image = image;
        this.fkBrandCar = fkBrandCar;
        this.fkFuelCar = fkFuelCar;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public int getMaGuixe() {
        return maGuixe;
    }

    public void setMaGuixe(int maGuixe) {
        this.maGuixe = maGuixe;
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

    public int getGasoline() {
        return gasoline;
    }

    public void setGasoline(int gasoline) {
        this.gasoline = gasoline;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getFkBrandCar() {
        return fkBrandCar;
    }

    public void setFkBrandCar(int fkBrandCar) {
        this.fkBrandCar = fkBrandCar;
    }

    public int getFkFuelCar() {
        return fkFuelCar;
    }

    public void setFkFuelCar(int fkFuelCar) {
        this.fkFuelCar = fkFuelCar;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CarDTO carDTO = (CarDTO) target;
        if (carDTO.getPrice() <  100 || carDTO.getPrice() > 9999){
            errors.rejectValue(("price"),null,"Không đủ hoặc thiếu tiền mua");
        }
    }
}
