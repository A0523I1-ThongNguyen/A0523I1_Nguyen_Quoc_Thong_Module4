package com.example.ss7_picture.service;

import com.example.ss7_picture.model.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPictureService {
    List<Picture> findAll();
    boolean add(Picture picture);
    Picture findById(int id);
    boolean updateAwesome(int id);
    boolean updateGreat(int id);
    Page<Picture> findAll(Pageable pageable);
}