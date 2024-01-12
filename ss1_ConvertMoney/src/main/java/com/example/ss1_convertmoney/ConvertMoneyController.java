package com.example.ss1_convertmoney;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/convert")
public class ConvertMoneyController {
    @GetMapping(value = "/money")
    public String showView() {
        return "/index";
    }

    @PostMapping(value = "/money")
    public String chuyenDoi(@RequestParam String e,int money,  Model model) {
        int cd = 0;
        if (e.equals("usd")) {
            cd = money / 25000;
        }
        if (e.equals("vnd")) {
            cd = money * 25000;
        }
        model.addAttribute("cd", cd);


        return "/index";
    }
}
