package com.example.validate_form_dang_ki.service;

import com.example.validate_form_dang_ki.model.User;
import com.example.validate_form_dang_ki.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public void add(User user) {
        userRepository.save(user);
    }
}
