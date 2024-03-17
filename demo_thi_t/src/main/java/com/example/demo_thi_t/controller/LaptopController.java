package com.example.demo_thi_t.controller;

import com.example.demo_thi_t.dto.LaptopDTO;
import com.example.demo_thi_t.model.Brand;
import com.example.demo_thi_t.model.Laptop;
import com.example.demo_thi_t.service.IBrandService;
import com.example.demo_thi_t.service.ILaptopService;
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

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/laptop")
public class LaptopController {
    @Autowired
    private ILaptopService iLaptopService;
    @Autowired
    private IBrandService iBrandService;

    @ModelAttribute("listBrand")
    public List<Brand> showListBrand() {
        return iBrandService.findAll();
    }

    @GetMapping("")
    public String showView(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Sort sort = Sort.by("price").ascending();
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Laptop> laptopPage = iLaptopService.findAll(pageable);
        model.addAttribute("laptopPage", laptopPage);
        return "/list";
    }

    @GetMapping("/createView")
    public String createView(Model model) {
        model.addAttribute("LaptopDTO", new LaptopDTO());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@Valid  @ModelAttribute("LaptopDTO") LaptopDTO LaptopDTO, BindingResult bindingResult) {
        new LaptopDTO().validate(LaptopDTO, bindingResult);
        if (bindingResult.hasErrors()){
        return "/create";
        }

        Laptop laptopX = new Laptop();
        BeanUtils.copyProperties(LaptopDTO, laptopX);
        laptopX.setDateOfManufacture(LocalDate.now());
        iLaptopService.add(laptopX);
        return "redirect:/laptop";
    }

    @GetMapping("/updateView")
    public String updateView(Model model ,Long idLaptop){
        Laptop laptopX = iLaptopService.findById(idLaptop);
        LaptopDTO LaptopDTO = new LaptopDTO();
        BeanUtils.copyProperties(laptopX,LaptopDTO);
        model.addAttribute("LaptopDTO",LaptopDTO);
        return "/update";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute("LaptopDTO") LaptopDTO LaptopDTO, BindingResult bindingResult){
        Laptop laptopX = new Laptop();
        BeanUtils.copyProperties(LaptopDTO, laptopX);
        laptopX.setDateOfManufacture(LocalDate.now());
        iLaptopService.update(laptopX);
        return "redirect:/laptop";
    }

}
