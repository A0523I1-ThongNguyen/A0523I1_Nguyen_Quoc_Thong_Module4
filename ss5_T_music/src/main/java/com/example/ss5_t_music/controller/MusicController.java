package com.example.ss5_t_music.controller;

import com.example.ss5_t_music.model.Music;
import com.example.ss5_t_music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String showView(Model model) {
        List<Music> listMusic = iMusicService.findAll();
        model.addAttribute("listMusic", listMusic);
        return "/list";
    }

    @GetMapping("/create")
    public String showViewCreate(Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute Music music2) {
        iMusicService.add(music2);
        return "redirect:/music";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        iMusicService.delete(id);
        return "redirect:/music";
    }

    @GetMapping("/update/{id}")
    public String showViewUpdate(@PathVariable int id, Model model) {
        Music music = iMusicService.findById(id);
        model.addAttribute("musicfindById", music);
        return "/update";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute Music musicfindById) {
        iMusicService.update(musicfindById);
        return "redirect:/music";
    }


}
