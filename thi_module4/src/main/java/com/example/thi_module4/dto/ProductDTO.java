package com.example.thi_module4.dto;

import com.example.thi_module4.model.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDTO implements Validator {
    private Long idProduct;

    @NotBlank(message = "Khong duoc rong")
    @Size(max = 50 ,min = 5 , message = "5 -> 50 character")
    private String nameProduct;

    private double price;
    private String status;
    private Category category;

    public ProductDTO() {
    }

    public ProductDTO(Long idProduct, String nameProduct, double price, String status, Category category) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
       if (productDTO.getPrice() < 100000){
           errors.rejectValue("price",null,"Giá phải lớn hơn 100.000 VND");
       }
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }

//    @Override
//    public void validate(Object target, Errors errors) {
//        ProductDTO productDTO = (ProductDTO) target;
//        if (productDTO.getPrice() < 100000){
//            errors.rejectValue("price",null,"Giá phải lớn hơn 100.000 VND");
//        }
//    }
}
