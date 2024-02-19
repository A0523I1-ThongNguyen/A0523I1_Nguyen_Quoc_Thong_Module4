package com.example.ss9_app_muon_sach.repository.person;

import com.example.ss9_app_muon_sach.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPersonRepository extends JpaRepository<Person,Integer> {
    @Query(value = "select count(*) from person where id_person = :idPerson",nativeQuery = true)
    int checkIdPerson(@Param("idPerson") int idPerson);

}
