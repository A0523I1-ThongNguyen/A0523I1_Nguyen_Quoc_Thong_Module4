package com.example.ss7_next_level_blog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    private Integer CategoryID;
    private String type;

    public Category() {
    }

    public Category(Integer categoryID, String type) {
        CategoryID = categoryID;
        this.type = type;
    }

    public Integer getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Integer categoryID) {
        CategoryID = categoryID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
