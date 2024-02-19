package com.example.ss8_test_music.controller;

import com.example.ss8_test_music.dto.MusicDTO;
import com.example.ss8_test_music.model.Music;

import com.example.ss8_test_music.service.music.IMusicService;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String showView(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Sort sort = Sort.by("view").descending();
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Music> musicPage = musicService.findAll(pageable);
        model.addAttribute("musicPage", musicPage);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("musicDTO", new MusicDTO());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@Valid @ModelAttribute("musicDTO") MusicDTO musicDTO, BindingResult bindingResult){
        new MusicDTO().validate(musicDTO , bindingResult);
        if (bindingResult.hasErrors()){
            return "/create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO,music);
        musicService.save(music);
        return "redirect:/music";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id_user) {
        musicService.delete(id_user);
        return "redirect:/music";
    }
    @GetMapping("getSearch")
    public String getSearch(@RequestParam (defaultValue = "0" , required = false) int page, String searchName,  Model model){
            Pageable pageable = PageRequest.of(page,2);
//            Page<Music> pageSearchNameSong = musicService.findByNameSongContaining(pageable,searchName);
//            model.addAttribute("pageSearchNameSong",pageSearchNameSong);
            Page<Music> musicPage = musicService.searchSingerAndSong(pageable,searchName ,searchName);
            model.addAttribute("musicPage",musicPage);
            return "/list";
    }

    @GetMapping("/type/{id}")
    public String type(@PathVariable int id ,@RequestParam(defaultValue = "0",required = false) int page, Model model){
        Pageable pageable = PageRequest.of(page,2);
        Page<Music> musicPage = musicService.searchForeignKeyOfMusic(pageable,id);
        model.addAttribute("musicPage",musicPage);
        return "/list";
    }
}
