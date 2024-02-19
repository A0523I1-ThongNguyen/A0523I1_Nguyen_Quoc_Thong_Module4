package com.example.ss9_app_muon_sach.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;
    @NotBlank(message = "Khong duoc de trong")
    private String nameBook;
    private int quantityBook;

    @OneToMany(mappedBy = "book")
    private List<Person> listPersonBookBorrwed;

    public Book() {
    }

    public List<Person> getListPersonBookBorrwed() {
        return listPersonBookBorrwed;
    }

    public void setListPersonBookBorrwed(List<Person> listPersonBookBorrwed) {
        this.listPersonBookBorrwed = listPersonBookBorrwed;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getQuantityBook() {
        return quantityBook;
    }

    public void setQuantityBook(int quantityBook) {
        this.quantityBook = quantityBook;
    }
}
