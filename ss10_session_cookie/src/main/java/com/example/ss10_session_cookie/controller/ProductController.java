package com.example.ss10_session_cookie.controller;

import com.example.ss10_session_cookie.dto.CartDto;
import com.example.ss10_session_cookie.dto.ProductDto;
import com.example.ss10_session_cookie.model.Product;
import com.example.ss10_session_cookie.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping("")
    public String showListProduct(Model model) {
        model.addAttribute("products", iProductService.findAll());
        return "product/productList";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable long id, HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product", iProductService.findById(id));
        return "product/detail";
    }

    @GetMapping("/add/{id}")
    public String addProduct(@PathVariable long id,
                             @SessionAttribute(value = "cart",required = false) CartDto cartDto) {
        Product product = iProductService.findById(id);
        if(product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}