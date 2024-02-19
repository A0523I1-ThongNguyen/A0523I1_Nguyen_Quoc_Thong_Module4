package com.example.ss3_mail.service;

import com.example.ss3_mail.model.Mail;
import com.example.ss3_mail.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MailService implements IMailSerice{
    @Autowired
    IMailRepository mailRepository;
    @Override
    public ArrayList<Mail> findAll() {
        return mailRepository.findAll();
    }

    @Override
    public void update(Mail mail) {

    }
    public Mail findById(int id){
        return mailRepository.findById(id);
    }

    @Override
    public void edit(int id, Mail newMail) {
        mailRepository.edit(id,newMail);
    }

    @Override
    public void add(Mail mail) {
        mailRepository.add(mail);
    }

    @Override
    public void delete(int id) {
        mailRepository.delete(id);
    }

    public void editName(String name, Mail newMail){
        mailRepository.editName(name,newMail);
    }

//    public void update(Mail mail) {
//        mailRepository.update(mail);
//    }
}
