package com.example.ss6_blog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Blog {
    @Id
    private int id;
    private String author;
    String tittle;
    private LocalDate writeDate;

    public Blog() {
    }

    public Blog(int id, String author, String tittle, LocalDate writeDate) {
        this.id = id;
        this.author = author;
        this.tittle = tittle;
        this.writeDate = writeDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public LocalDate getWriteDate() {
        return writeDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setWriteDate(LocalDate writeDate) {
        this.writeDate = writeDate;
    }
    // hàm set để database đẩy dữ liệu lên , còn hàm get để thymeleaf lấy dữ liệu từ DB lên hiển thị ra
    // định dạng mặc định của DB là yyyy-MM-dd, trong khi thẻ input type="date" mặc định là dd/mm/yyyy
}
