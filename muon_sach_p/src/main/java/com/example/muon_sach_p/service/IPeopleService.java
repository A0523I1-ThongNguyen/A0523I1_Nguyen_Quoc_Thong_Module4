package com.example.muon_sach_p.service;

import com.example.muon_sach_p.exception.PersonIdNotExist;
import com.example.muon_sach_p.model.People;

public interface IPeopleService {
    int createPeopleId();

    boolean updatePeople(People people);

    boolean deletePeople(People people);
    People findPeopleByPeopleId(int peopleId) throws PersonIdNotExist;
}