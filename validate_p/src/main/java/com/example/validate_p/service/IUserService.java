package com.example.validate_p.service;

import com.example.validate_p.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    boolean add(User user);
}