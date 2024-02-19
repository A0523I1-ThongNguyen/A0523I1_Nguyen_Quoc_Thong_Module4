package com.example.validate_p.service;

import com.example.validate_p.model.User;
import com.example.validate_p.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public boolean add(User user) {
        try {
            iUserRepository.save(user);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}