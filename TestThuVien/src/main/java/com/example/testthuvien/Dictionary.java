package com.example.testthuvien;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/dic")
@Controller
public class Dictionary {
    @GetMapping(value = "/get")
    public String showView(){
        return "/list";
    }
}
