package com.example.ss3_thu_dien_tu.service;

import com.example.ss3_thu_dien_tu.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> getAll();
    Email findById(int id);
}
