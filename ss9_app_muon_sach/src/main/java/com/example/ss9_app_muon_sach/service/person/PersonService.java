package com.example.ss9_app_muon_sach.service.person;

import com.example.ss9_app_muon_sach.model.Person;
import com.example.ss9_app_muon_sach.repository.person.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepository iPersonRepository;

    @Override
    public boolean update(Person person) {
        iPersonRepository.save(person);
        return true;
    }

    @Override
    public int idPersonRandom() {
        int count;
        String convertIAndS;
        do {
            int[] numbers = new int[5];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (int) (Math.random() * 10);
            }
            convertIAndS = "";
            for (int num : numbers) {
                convertIAndS += Integer.toString(num);
            }
            count =iPersonRepository.checkIdPerson(Integer.parseInt(convertIAndS));
        } while (count != 0);
        return Integer.parseInt(convertIAndS);
    }

    @Override
    public void delete(int id) {
        iPersonRepository.deleteById(id);
    }

    @Override
    public Person findById(int id) {
        return iPersonRepository.findById(id).orElse(null);
    }

    @Override
    public Long generateRandomIdPerson() {
        return null;
    }


}
