package com.example.many_to_many.Controller;


import com.example.many_to_many.model.Product;
import com.example.many_to_many.service.CategoryService;
import com.example.many_to_many.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/p")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String show(Model model){
        List<Product> productList = productService.getProductsByCategory(2L);
        model.addAttribute("productList",productList);
        model.addAttribute("categoryList",categoryService.findAll());
        return "/list";
    }
}
