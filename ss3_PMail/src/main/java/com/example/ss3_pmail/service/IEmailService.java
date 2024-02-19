package com.example.ss3_pmail.service;

import com.example.ss3_pmail.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();
    void save(Email email);
    Email findById(int id);
    void delete(int id);
    void update(int id, Email email);
}
