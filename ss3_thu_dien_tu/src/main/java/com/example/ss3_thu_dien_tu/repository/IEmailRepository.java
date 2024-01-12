package com.example.ss3_thu_dien_tu.repository;

import com.example.ss3_thu_dien_tu.model.Email;

import java.util.ArrayList;
import java.util.List;

public interface IEmailRepository {
    List<Email> getAll();
    Email findById(int id);
}
