package com.example.ss3_mail.controller;

import com.example.ss3_mail.model.Mail;
import com.example.ss3_mail.service.IMailSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
@Controller
@RequestMapping(value ="/service")
public class MailController {
    @Autowired
    IMailSerice mailSerice;
    @GetMapping(value ="/edit")
    public String showFormEdit (@RequestParam int id, Model model, Mail mailList){
        Mail findMail = mailSerice.findById(id);
        model.addAttribute("mail",new Mail());
        model.addAttribute("mailList", findMail);
        model.addAttribute("lan", new String[]{"English","VietNamese","Chinaese","Japanese"});
        model.addAttribute("page",new String []{"10","15","20","25","50","100"});
        return "/create";
    }
    @GetMapping(value = "/show")
    public  ModelAndView showForm(){
        ArrayList<Mail> mailList = mailSerice.findAll();
        ModelAndView model12 = new ModelAndView("/list","mailList",mailList);
        return model12;
    }
    @PostMapping(value = "/edit")
    public String editForm(@ModelAttribute ("mailList") Mail mailList){
        mailSerice.edit(mailList);
        return "redirect:/service/show";
    }

}