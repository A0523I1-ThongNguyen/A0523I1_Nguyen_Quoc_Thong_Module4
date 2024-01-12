package com.example.ss3_mail.repository;

import com.example.ss3_mail.model.Mail;
import com.example.ss3_mail.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;

@Repository
public class MailRepository implements IMailRepository{
    static ArrayList<Mail> mailList = new ArrayList<Mail>();
    static{
        mailList.add(new Mail( 1,new String[]{"English","VietNamesse"},new String[]{"25","10","5"},"0",new String[]{"King","Agrad"}));
        mailList.add(new Mail( 2,new String[]{"English"},new String[]{"25","10","5"},"0",new String[]{"King","Agrad"}));
        mailList.add(new Mail( 3, new String[]{"English"},new String[]{"25","10","5"},"0",new String[]{"King","Agrad"}));
    }
    public ArrayList<Mail> findAll(){
        return mailList;
    }
    public Mail findById(int id){
        Mail findMail= null;
        for(Mail newMail : mailList){
            if(newMail.getId() ==   id){
                findMail= newMail;
            }
        }
        return findMail;
    }



    @Override
    public void edit(Mail student) {
        mailList.remove(student.getId());
        mailList.add(student);
    }



}
