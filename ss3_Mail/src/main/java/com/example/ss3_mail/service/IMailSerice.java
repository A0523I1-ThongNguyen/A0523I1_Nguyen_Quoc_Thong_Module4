package com.example.ss3_mail.service;

import com.example.ss3_mail.model.Mail;

import java.util.ArrayList;

public interface IMailSerice {
    ArrayList<Mail> findAll();
    void update(Mail mail);
    Mail findById(int id);
    void edit(int id , Mail newMail);
    void add(Mail mail);
    void delete(int id);
    public void editName(String name, Mail newMail);
}
