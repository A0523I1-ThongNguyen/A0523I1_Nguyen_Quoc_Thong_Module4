package com.example.car_thymeleaf.controller;

import com.example.car_thymeleaf.model.Car;
import com.example.car_thymeleaf.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "car")
public class CarController {
    @Autowired
    ICarService carService;

    @GetMapping(value = "get")
    public String showList(Model model){
        List<Car> listcar = carService.findAll();
        model.addAttribute("listcar",listcar);
        return "/test";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id){
        carService.delete(id);
        return "redirect:/car/get";
    }
}
