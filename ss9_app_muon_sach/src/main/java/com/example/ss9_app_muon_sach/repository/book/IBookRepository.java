package com.example.ss9_app_muon_sach.repository.book;

import com.example.ss9_app_muon_sach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
}
