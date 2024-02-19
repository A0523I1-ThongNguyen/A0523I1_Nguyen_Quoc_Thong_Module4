package com.example.ss7_next_level_blog.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String author;
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    private LocalDate dateOfWrite;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "CategoryID")
    private Category category;

    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public LocalDate getDateOfWrite() {
        return dateOfWrite;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setDateOfWrite(LocalDate dateOfWrite) {
        this.dateOfWrite = dateOfWrite;
    }

    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }
}
