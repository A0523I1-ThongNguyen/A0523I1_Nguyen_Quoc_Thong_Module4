package com.example.ss4_thymeleaf_product.controller;

import com.example.ss4_thymeleaf_product.model.Product;
import com.example.ss4_thymeleaf_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/pro")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public String showView(Model model) {
        List<Product> listProduct = productService.findAll();
        model.addAttribute("listProduct", listProduct);
        return "/list";
    }

    @GetMapping("/create")
    public String showViewCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/postCreate")
    public String postCreate(@ModelAttribute Product product) {
        productService.add(product);
        return "redirect:/pro";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        productService.delete(id);
        return "redirect:/pro";
    }

//    @GetMapping(value = "/delete/{id}")
//    public String delete2(@PathVariable int id){
//        productService.delete(id);
//        return "redirect:/pro";
//    }

    @GetMapping("/chitiet")
    public ModelAndView chiTiet(@RequestParam int id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/chitiet", "product", product);
        return modelAndView;
    }

    @GetMapping("update/{id}")
    public String showViewUpdate(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/update";
    }


    @GetMapping("update2/{ok}")
    public String showViewUpdate2(@PathVariable int ok, Model model) {
        Product product = productService.findById(ok);
        model.addAttribute("product", product);
        return "/update";
    }

    @PostMapping("/postUpdate")
    public String postUpdate(@ModelAttribute Product product) {
        productService.update(product.getId(), product);
        return "redirect:/pro";
    }

    @PostMapping("/search")
    public String search(@RequestParam String search, Model model, RedirectAttributes redirectAttributes) {
        List<Product> listProduct = productService.listSearch(search);
        if (listProduct.size() > 0) {
            model.addAttribute("listProduct", listProduct);
            return "/list";
        } else {
            redirectAttributes.addFlashAttribute("notfind", "Not product on list");
            return "redirect:/pro";
        }
    }

    @GetMapping("/search2")
    public String search2(@RequestParam String search2, Model model, RedirectAttributes redirectAttributes) {
        List<Product> listSearch2 = productService.listSearch2(search2);
        if (listSearch2.size() == 0) {
            redirectAttributes.addFlashAttribute("notfind2", "No Product Found");
            return "redirect:/pro";
        } else {
            model.addAttribute("listProduct", listSearch2);
            return "/list";
        }
    }
}
