package com.example.ss9_app_muon_sach.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Entity
public class Person implements Validator {
    @Id
    private int idPerson;
    @NotNull
    private String namePerson;
    private String nameBookBorrwed;

    //mỗi Person có thể mượn một Book duy nhất thông qua thuộc tính book.@JoinColumn private Book book;
    // Một Book có thể được mượn bởi nhiều Person khác nhau thông qua quan hệ nhiều-1.ManyToOne
    @ManyToOne
    @JoinColumn(name = "fk_book", referencedColumnName = "idBook")
    private Book book;

    public Person() {
    }

    public Person(int idPerson, String namePerson, String nameBookBorrwed, Book book) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.nameBookBorrwed = nameBookBorrwed;
        this.book = book;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getNameBookBorrwed() {
        return nameBookBorrwed;
    }

    public void setNameBookBorrwed(String nameBookBorrwed) {
        this.nameBookBorrwed = nameBookBorrwed;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if(person.getIdPerson() > 99999) {
            errors.rejectValue("idPerson",null,"Code Person < 5 ");
        }
    }
}
