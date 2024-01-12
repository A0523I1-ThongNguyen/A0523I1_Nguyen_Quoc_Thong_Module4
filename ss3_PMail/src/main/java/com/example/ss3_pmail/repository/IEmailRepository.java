package com.example.ss3_pmail.repository;

import com.example.ss3_pmail.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> findAll();
    void save(Email email);
    Email findById(int id);
    void delete(int id);
}
