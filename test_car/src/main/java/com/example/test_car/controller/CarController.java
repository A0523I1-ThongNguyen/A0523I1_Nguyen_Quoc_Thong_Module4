package com.example.test_car.controller;

import com.example.test_car.model.Car;
import com.example.test_car.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/car")
@Controller
public class CarController {

    @Autowired
    private ICarService carService;

    @GetMapping("/show")
    public String showList(Model model) {
        List<Car> listCar = carService.findAll();
        model.addAttribute("listCar", listCar);
        return "/list";
    }

    @GetMapping("/showViewCreate")
    public String showCreate(Model model) {
        model.addAttribute("car", new Car());
        return "/create";
    }

    @ModelAttribute("brandList")
    public String[] showListBrand(){
        return new String []{"Toyota","Huyndai","Ford"};
    }

    @PostMapping("/create")
    public String add(@ModelAttribute Car car, RedirectAttributes redirectAttributes){
        carService.add(car);
        redirectAttributes.addFlashAttribute("flash","Added Object :v");
        return "redirect:/car/show";
    }
    @PostMapping("/delete")
        public String delete(@RequestParam int id){
        carService.delete(id);
        return "redirect:/car/show";
        }
}
