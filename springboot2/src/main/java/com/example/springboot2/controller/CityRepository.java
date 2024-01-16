package com.example.springboot2.controller;

import com.example.springboot2.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ct")
public class CityRepository {
    @Autowired
    private ICityService service;

    @GetMapping("")
    public ModelAndView showView(){
        return new ModelAndView("/list","list",service.findAll());
    }

}
