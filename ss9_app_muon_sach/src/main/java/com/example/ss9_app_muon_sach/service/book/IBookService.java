package com.example.ss9_app_muon_sach.service.book;

import com.example.ss9_app_muon_sach.model.Book;
import com.example.ss9_app_muon_sach.repository.book.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IBookService {
  List<Book> findAll();
  boolean update(Book book);
  Book findById(int id);

}
