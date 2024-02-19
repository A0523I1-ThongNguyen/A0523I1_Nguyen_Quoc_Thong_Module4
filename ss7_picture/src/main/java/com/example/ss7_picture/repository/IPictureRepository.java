package com.example.ss7_picture.repository;


import com.example.ss7_picture.model.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPictureRepository extends JpaRepository<Picture,Integer> {

}