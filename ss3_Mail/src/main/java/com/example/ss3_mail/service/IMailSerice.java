package com.example.ss3_mail.service;

import com.example.ss3_mail.model.Mail;

import java.util.ArrayList;

public interface IMailSerice {
    ArrayList<Mail> findAll();
    void update(Mail mail);
    Mail findById(int id);
    void edit(Mail student);
}
