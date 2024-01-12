package com.example.orm_demo.model;


import jakarta.persistence.AttributeConverter;

public class ConvertLanguages implements AttributeConverter<String[],String> {
    //    Chuyển đổi thuộc tính đối tượng thành trường ở DB
    @Override
    public String convertToDatabaseColumn(String[] attribute) {
        return attribute != null ? String.join(",",attribute) : null;
    }
    //  Ngược lại
    @Override
    public String[] convertToEntityAttribute(String dbData) {
        return dbData != null ? dbData.split(",") : null;
    }
}
