package com.example.muon_sach_p.service;

import com.example.muon_sach_p.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> listBook();
    Book findByBookId(int bookId);
    boolean updateBook(Book book);
}