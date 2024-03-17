package com.example.demo_thi_t.service;

import com.example.demo_thi_t.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILaptopService {
    //        Page<QuestionContent> findAll(Pageable pageable);
//    void save(QuestionContent questionContent);
//    void delete(QuestionContent questionContent);
//    QuestionContent findById(Long id);
//    List<QuestionContent> findAll();
    Page<Laptop> findAll(Pageable pageable);
    void add(Laptop laptop);
    void update(Laptop laptop);
    void delete(Long idLaptop);
    Laptop findById(Long idLaptop);
    List<Laptop> findAll();
}
