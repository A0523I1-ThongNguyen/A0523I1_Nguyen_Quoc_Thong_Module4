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
    public  void edit(Mail student){
        mailRepository.edit(student);
    }


//    public void update(Mail mail) {
//        mailRepository.update(mail);
//    }
}
