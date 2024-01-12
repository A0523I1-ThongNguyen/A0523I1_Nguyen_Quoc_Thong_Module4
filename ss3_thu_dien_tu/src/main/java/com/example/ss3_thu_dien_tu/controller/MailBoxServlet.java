package com.example.ss3_thu_dien_tu.controller;

import com.example.ss3_thu_dien_tu.model.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailBoxServlet {
    @GetMapping("/p")
    public String show(Model model) {
        model.addAttribute("mailBox", new MailBox());
        model.addAttribute("languages",new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("size", new String[]{"5", "10", "15", "25", "50", "100"});
        model.addAttribute("signature", new String[]{"King , Asgard"});
        return "/index";
    }
    @PostMapping("/pp")
    public String create(@ModelAttribute MailBox mailBox,Model model) {
        MailBox mailBox1 = mailBox;
        model.addAttribute("mailBox1",mailBox1);
        return "/index";
    }
}