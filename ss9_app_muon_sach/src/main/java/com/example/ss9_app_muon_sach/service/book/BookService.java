package com.example.ss9_app_muon_sach.service.book;

import com.example.ss9_app_muon_sach.model.Book;
import com.example.ss9_app_muon_sach.repository.book.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public boolean update(Book book) {
        try {
            iBookRepository.save(book);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).orElse(null);
    }

}
