package com.example.ss5_orm_product.controller;

import com.example.ss5_orm_product.model.Product;
import com.example.ss5_orm_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sp")
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping("")
    public String showView(Model model) {
        List<Product> listProduct = service.findAll();
        model.addAttribute("listProduct", listProduct);
        return "/list";
    }

    @GetMapping("/create")
    public String showViewCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute Product product) {
        service.add(product);
        return "redirect:/sp";
    }

    @GetMapping("/chitiet")
    public ModelAndView chiTietSp(@RequestParam int id) {
        Product product = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("/chitiet", "product", product);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        service.delete(id);
        return "redirect:/sp";
    }

    @GetMapping("/getUptate")
    public ModelAndView getUpdate(@RequestParam int id){
        Product product = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("/update","product",product);
        return modelAndView;
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute Product product){
            service.update(product, product);
            return "redirect:/sp";
    }
}
