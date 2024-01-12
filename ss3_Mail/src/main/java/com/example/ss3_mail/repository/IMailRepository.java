package com.example.ss3_mail.repository;

import com.example.ss3_mail.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface IMailRepository {
    ArrayList<Mail> findAll();
    Mail findById(int id);
    void edit(Mail student);
}

