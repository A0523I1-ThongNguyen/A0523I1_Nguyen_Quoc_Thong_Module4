package com.example.ss9_app_muon_sach.service.person;

import com.example.ss9_app_muon_sach.model.Person;

public interface IPersonService {
    boolean update(Person person);

    int idPersonRandom();
    void delete(int id);
    Person findById(int id);
    public Long generateRandomIdPerson();
}
