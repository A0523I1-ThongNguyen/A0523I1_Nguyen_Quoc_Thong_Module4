package com.example.ss3_listening_to_music.controller;

import com.example.ss3_listening_to_music.model.Music;
import com.example.ss3_listening_to_music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/music")
public class MusicController {
    @Autowired
    private IMusicService service;

    @GetMapping(value = "")
    public String showView(Model model) {
        List<Music> listMusic = service.getAll();
        model.addAttribute("listMusic", listMusic);
        return "/list";
    }

    @GetMapping(value = "/showViewCreate")
    public String showViewCreate(Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Music music){
        service.add(music);
        return "redirect:/music";
    }


    @ModelAttribute("listType")
    public String[] listType() {
        return new String[]{"Tinh cam", "Tru tinh", "Rap"};
    }

}
