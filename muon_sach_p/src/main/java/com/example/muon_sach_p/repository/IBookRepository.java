package com.example.muon_sach_p.repository;

import com.example.muon_sach_p.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}