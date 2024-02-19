package com.example.ss3_pmail.repository;

import com.example.ss3_pmail.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    static List<Email> listEmail = new ArrayList<>();

    static {
        listEmail.add(new Email(1, new String[]{"Englis", "Vietnamese", "Japanese"}, new String[]{"5,10,25,50,100"}, "0", "King"));
        listEmail.add(new Email(2, new String[]{"Englis", "", "Japanese"}, new String[]{"5,10,25,50,100"}, "0", "Messi"));
        listEmail.add(new Email(3, new String[]{"Englis", "", ""}, new String[]{"5,10,25,50,100"}, "2", "Arteta"));
    }

    @Override
    public List<Email> findAll() {
        return listEmail;
    }

    @Override
    public void save(Email email) {
        listEmail.add(email);
    }

    @Override
    public Email findById(int id) {
        Email findEmail = null;
        for (int i = 0; i < listEmail.size(); i++) {
            if (listEmail.get(i).getId() == id) {
                findEmail = listEmail.get(i);
            }
        }
        return findEmail;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < listEmail.size(); i++) {
            if (listEmail.get(i).getId() == id) {
                listEmail.remove(i);
            }
        }
    }

    @Override
    public void update(int id, Email email) {
        for (int i = 0; i < listEmail.size(); i++){
            if (listEmail.get(i).getId()==id){
                listEmail.set(id,email);
            }
        }
    }
}

