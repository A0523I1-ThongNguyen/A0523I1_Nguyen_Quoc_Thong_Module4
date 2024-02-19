package com.example.ss3_pmail.service;

import com.example.ss3_pmail.model.Email;
import com.example.ss3_pmail.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService{
    @Autowired
    private IEmailRepository repository;
    @Override
    public List<Email> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Email email) {
        repository.save(email);
    }

    @Override
    public Email findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void update(int id, Email email) {
        repository.update(id,email);
    }


}
