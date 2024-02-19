package com.example.test_ss9_validate_oap_exception.controller;

import com.example.test_ss9_validate_oap_exception.dto.CarDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/car")
public class TestController {
    @GetMapping("/view-update2")
    public String viewUpdate(Model model){
        model.addAttribute("carDTO",new CarDTO());
        return "/nullpoint";
    }
}
