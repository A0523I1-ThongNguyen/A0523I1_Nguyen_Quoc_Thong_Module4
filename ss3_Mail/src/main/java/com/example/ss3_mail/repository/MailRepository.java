package com.example.ss3_mail.repository;

import com.example.ss3_mail.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailRepository implements IMailRepository {
    static ArrayList<Mail> mailList = new ArrayList<>();;

    static {
        mailList.add(new Mail(43, new String[]{"English", "VietNamesse"}, new String[]{"25", "10", "5"}, "1", new String[]{"hihi", "it"}));
        mailList.add(new Mail(75, new String[]{"English"}, new String[]{"25", "10", "5"}, "2", new String[]{"zizu"}));
        mailList.add(new Mail(47, new String[]{"English"}, new String[]{"25", "10", "5"}, "3", new String[]{"King", "Agrad"}));
    }

    public ArrayList<Mail> findAll() {
        return mailList;
    }

    @Override
    public void add(Mail mail) {
        mailList.add(mail);
    }


    public Mail findById(int id) {
        Mail findMail = null;
        for (Mail mail : mailList) {
            if (mail.getId() == id) {
                findMail = mail;
            }
        }
        return findMail;
    }


    @Override
    public void edit(int id, Mail newMail) {
        for (int i = 0; i < mailList.size(); i++) {
            if (mailList.get(i).getId() == id) {
                mailList.set(i, newMail);
            }
        }
    }

    public void editName(String name, Mail newMail) {
        for (int i = 0; i < mailList.size(); i++) {
            if (mailList.get(i).getSpams_Fillter().equals(name) ) {
                mailList.set(i, newMail);
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < mailList.size(); i++) {
            if (mailList.get(i).getId() == id) { // get(indexOBJ).getId()OfObject == id
                mailList.remove(i); // remove index Object
            }
        }
    }

}
