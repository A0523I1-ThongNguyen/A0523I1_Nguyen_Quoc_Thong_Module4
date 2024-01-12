package com.example.test.controller;

import com.example.test.model.Music;
import com.example.test.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping(value ="/music")

public class MusicController {
    @Autowired
    IMusicService service;
    @GetMapping(value ="/show")// nếu đặt debug ban đầu ở đây tức là đã hiển thị ngoài web.
    public String showForm(Model model){
        ArrayList<Music> musicList = service.findALL();// đặt debug bước 2
        model.addAttribute("music", musicList);
        return "/index";
    }
    @GetMapping(value ="/create")
    public String showFormCreate(Model model){
        model.addAttribute("newMusic", new Music());
        model.addAttribute("category",new String[]{"us", "uk", "speedup"});
        return "/Upload";
    }
    @PostMapping(value ="/create")
    public String Create (@ModelAttribute("newMusic") Music newMusic, RedirectAttributes redirect){
        service.addMusic(newMusic); // đặt debug bước 1
        redirect.addFlashAttribute("mess","uploadsuccess");
        return "redirect:/music/show";
    }


}