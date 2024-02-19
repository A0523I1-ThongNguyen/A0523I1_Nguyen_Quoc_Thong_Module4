package com.example.ss7_check_blog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Style {
    @Id
    private int idStyle;
    private String theLoai;

    public Style() {
    }

    public int getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
}
