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
    @ModelAttribute("listLanguage")
    public String[] listLanguage() {
        return new String[]{"English", "Vietnamese", "Japanese", ""};
    }
    @ModelAttribute("listSize")
    public String[] listSize(){
        return new String[]{"1","5","20","100"};
    }

    @GetMapping(value = "/show")
    public  ModelAndView showForm(){
        ArrayList<Mail> mailList = mailSerice.findAll();
        ModelAndView model12 = new ModelAndView("/list","mailList",mailList);
        return model12;
    }

    @GetMapping(value = "/createView")
    public String createView(Model model){
        model.addAttribute("mail",new Mail());
        return "/create";
    }
    @PostMapping(value = "/createPost")
    public String createPost(@ModelAttribute Mail mail){
        mailSerice.add(mail);
        return "redirect:/service/show";
    }

    @GetMapping("updateView")
    public String viewEdit(@RequestParam int id , Model model){
     Mail mail = mailSerice.findById(id);
     model.addAttribute("mail",mail);
     return "/update";
    }
    @PostMapping(value = "/updatePost")
    public String updatePost(@ModelAttribute Mail mail){
        mailSerice.edit(mail.getId(), mail);
        return "redirect:/service/show";
    }
//    @PostMapping(value = "/updatePost")
//    public String updatePost(@ModelAttribute Mail mail){
//        mailSerice.editName(mail.getSpams_Fillter(), mail);
//        return "redirect:/service/show";
//    }
    @GetMapping(value = "/delete")
    public String delete(@RequestParam int id){
        mailSerice.delete(id);
        return "redirect:/service/show";
    }
}