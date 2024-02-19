//package com.example.ss9_app_muon_sach.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//
//import java.util.List;
//
//@Entity
//public class TypeBook {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idType;
//    @NotNull
//    private String nameType;
//    @OneToMany(mappedBy = "typeBook")
//    @NotNull
//    private List<Book> listBook;
//
//    public TypeBook() {
//    }
//
//    public TypeBook(Long idType, String nameType, List<Book> listBook) {
//        this.idType = idType;
//        this.nameType = nameType;
//        this.listBook = listBook;
//    }
//
//    public Long getIdType() {
//        return idType;
//    }
//
//    public void setIdType(Long idType) {
//        this.idType = idType;
//    }
//
//    public String getNameType() {
//        return nameType;
//    }
//
//    public void setNameType(String nameType) {
//        this.nameType = nameType;
//    }
//
//    public List<Book> getListBook() {
//        return listBook;
//    }
//
//    public void setListBook(List<Book> listBook) {
//        this.listBook = listBook;
//    }
//}
