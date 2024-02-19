package com.example.ss3_pmail.controller;

import com.example.ss3_pmail.model.Email;
import com.example.ss3_pmail.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "email")
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping(value = "get")
    public String showView(Model model) {
        List<Email> listEmail = emailService.findAll();
        model.addAttribute("listEmail", listEmail);
        return "/list";
    }

    @GetMapping(value = "viewcreate")
    public String showViewCreate(Model model) {
        model.addAttribute("Object", new Email());
        return "/create";
    }

    @PostMapping(value = "postcreate")
    public String createObject(@ModelAttribute("findMail") Email email) {
        emailService.save(email);
        return "redirect:/email/get";
    }

    @GetMapping(value = "getedit")
    public String getObjectEdit(@RequestParam int id, Model model) {
        Email findMail = emailService.findById(id);
        model.addAttribute("findMail", findMail);
        return "/edit";
    }

    @PostMapping(value = "delete")
    public String deleteObject(@RequestParam int id){
        emailService.delete(id);
        return "redirect:/email/get";
    }

    @ModelAttribute("listLanguage")
    public String[] listLanguage() {
        return new String[]{"English", "Vietnamese", "Japanese", ""};
    }

    @ModelAttribute("listSize")
    public String[] listSize() {
        return new String[]{"5", "10", "25", "50", "100", ""};
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute("findMail") Email findMail){
            emailService.update(findMail.getId(),findMail);
            return "redirect:/email/get";
    }
}
