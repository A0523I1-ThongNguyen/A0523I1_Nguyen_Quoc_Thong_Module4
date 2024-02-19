package com.example.validate_form_dang_ki.service;

import com.example.validate_form_dang_ki.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void add(User user);
}
