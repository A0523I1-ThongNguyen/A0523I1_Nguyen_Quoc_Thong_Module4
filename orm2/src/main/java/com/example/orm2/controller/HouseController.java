package com.example.orm2.controller;

import com.example.orm2.model.House;
import com.example.orm2.repository.IHouseRepository;
import com.example.orm2.service.HouseService;

import com.example.orm2.service.IHouserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping(value = "")
public class HouseController {
    @Autowired
    private IHouserService houseService;

    @GetMapping("/")
    public String showView(Model model) {
        List<House> listHouse = houseService.findAll();
        model.addAttribute("listHouse", listHouse);
        return "/list";
    }

    @GetMapping("/showViewCreate")
    public String showViewCreate(Model model) {
        model.addAttribute("house", new House());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute("house") House house) {
        houseService.add(house);
        return "redirect:/";
    }


}
