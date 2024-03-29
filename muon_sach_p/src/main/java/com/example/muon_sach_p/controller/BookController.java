package com.example.muon_sach_p.controller;

import com.example.muon_sach_p.dto.PeopleDto;
import com.example.muon_sach_p.exception.NoBookInLIbrary;
import com.example.muon_sach_p.exception.PersonIdNotExist;
import com.example.muon_sach_p.model.Book;
import com.example.muon_sach_p.model.People;
import com.example.muon_sach_p.service.IBookService;
import com.example.muon_sach_p.service.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IPeopleService iPeopleService;
    @GetMapping("")
    public String showListBook(Model model) {
        List<Book> bookList = iBookService.listBook();
        model.addAttribute("bookList",bookList);
        return "listBook";
    }
    @GetMapping("/borrowBooks/{bookId}")
        public String borrowBooks( Integer a ,@PathVariable int bookId, Model model,
                                 RedirectAttributes redirectAttributes) throws NoBookInLIbrary {
        a = 10;
        Book book = iBookService.findByBookId(bookId);
        if(book.getNumberOfBooks()==0) {
            throw new NoBookInLIbrary("Số lượng còn 0");
        } else {
            book.setNumberOfBooks(book.getNumberOfBooks() - 1);
            iBookService.updateBook(book);
            People people = new People();
            people.setPeopleId(iPeopleService.createPeopleId());
            people.setNameOfBook(book.getBookName());
            people.setBook(book);
            iPeopleService.updatePeople(people);
            a--;
            return "redirect:/books";
        }
    }
    @ExceptionHandler(NoBookInLIbrary.class)
    public String number0() {
        return "error_borrow";
    }
    @GetMapping("/pay")
    public String searchBookId(Model model) {
        model.addAttribute("peopleDto", new PeopleDto());
        return "pay";
    }
    @PostMapping("/pay")
    public String giveBookBack(@Valid @ModelAttribute PeopleDto peopleDto, BindingResult bindingResult,
                               Model model, RedirectAttributes redirectAttributes) throws PersonIdNotExist {
        new PeopleDto().validate(peopleDto,bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("peopleDto",peopleDto);
            return "pay";
        }
        int id = Integer.parseInt(peopleDto.getPeopleId());
        if(iPeopleService.findPeopleByPeopleId(id) == null) {
            model.addAttribute("errors","Mã không tồn tại");
            return "pay";
        }
        People people = iPeopleService.findPeopleByPeopleId(id);
        iPeopleService.deletePeople(people);
        Book book = iBookService.findByBookId(people.getBook().getBookId());
        book.setNumberOfBooks(book.getNumberOfBooks() + 1);
        iBookService.updateBook(book);
        return "redirect:/books";
    }
}