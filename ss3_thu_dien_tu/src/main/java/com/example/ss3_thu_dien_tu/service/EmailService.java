package com.example.ss3_thu_dien_tu.service;

import com.example.ss3_thu_dien_tu.model.Email;
import com.example.ss3_thu_dien_tu.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService{
@Autowired
    private IEmailRepository iEmailRepository;
    @Override
    public List<Email> getAll() {
        return iEmailRepository.getAll();
    }

    @Override
    public Email findById(int id) {
        return null;
    }
}
