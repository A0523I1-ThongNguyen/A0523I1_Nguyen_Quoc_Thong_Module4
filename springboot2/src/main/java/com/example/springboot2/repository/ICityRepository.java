package com.example.springboot2.repository;

import com.example.springboot2.model.City;
import com.example.springboot2.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface ICityRepository extends JpaRepository<City,Integer> {

}
