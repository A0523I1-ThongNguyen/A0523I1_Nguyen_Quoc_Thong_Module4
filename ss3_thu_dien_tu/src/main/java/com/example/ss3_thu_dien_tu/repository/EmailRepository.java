package com.example.ss3_thu_dien_tu.repository;

import com.example.ss3_thu_dien_tu.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository{
    static List<Email> listEmail = new ArrayList<>();
    static {
        listEmail.add(new Email(1,new String[]{"English"},new String[]{"5","10","15"},"0",new String[]{"King,Asgard"}));
        listEmail.add(new Email(2,new String[]{"Japanese"},new String[]{"25","50"},"0",new String[]{"King,Asgard"}));
        listEmail.add(new Email(3,new String[]{"Vietnamese,English"},new String[]{"5","100"},"0",new String[]{"King,Asgard"}));
    }
    @Override
    public List<Email> getAll() {
        return listEmail;
    }

    @Override
    public Email findById(int id) {
        return null;
    }
}
