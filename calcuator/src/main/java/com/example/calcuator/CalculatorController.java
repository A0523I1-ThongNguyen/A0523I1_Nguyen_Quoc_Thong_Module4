package com.example.calcuator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;



@Controller
@RequestMapping(value = "/search")
public class CalculatorController {
    @GetMapping(value ="/cal")
    public String showForm(Model model){
        return "/index";
    }
    @PostMapping(value ="/calp")
    public String Calculator(@RequestParam ( name = "e", required = false, defaultValue = "No Choose") String e, double num1, double num2,Model model){
        try {
            double result = 0;
            if (e.equals("plus")) {
                result = num1 + num2;
                System.out.println(result);
            }
            if (e.equals("subtraction")) {
                result = num1 - num2;
            }
            if (e.equals("multiplication")) {
                result = num1 * num2;
            }
            if (e.equals("division")) {
                result = num1 / num2;
            }
            model.addAttribute("result", result);
        }catch (Exception exception){
            System.out.println("Loi backend");
        }
        return "/index";
    }
}
