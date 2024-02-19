package com.example.muon_sach_p.service;

import com.example.muon_sach_p.model.Book;
import com.example.muon_sach_p.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> listBook() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findByBookId(int bookId) {
        return iBookRepository.findById(bookId).orElse(null);
    }

    @Override
    public boolean updateBook(Book book) {
        try {
            iBookRepository.save(book);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}