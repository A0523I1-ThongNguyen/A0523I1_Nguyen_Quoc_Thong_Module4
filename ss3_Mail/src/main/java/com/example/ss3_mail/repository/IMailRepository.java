package com.example.ss3_mail.repository;

import com.example.ss3_mail.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface IMailRepository {
    ArrayList<Mail> findAll();
    Mail findById(int id);
    void edit(int id , Mail mail );
    void add(Mail mail);
    void delete(int id);
    public void editName(String name, Mail newMail);
}

