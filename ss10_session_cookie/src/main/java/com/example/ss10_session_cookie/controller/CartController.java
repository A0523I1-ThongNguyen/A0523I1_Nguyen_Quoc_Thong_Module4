package com.example.ss10_session_cookie.controller;

import com.example.ss10_session_cookie.dto.CartDto;
import com.example.ss10_session_cookie.dto.ProductDto;
import com.example.ss10_session_cookie.model.Product;
import com.example.ss10_session_cookie.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private IProductService iProductService;

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false) CartDto cartDto) {
        return new ModelAndView("templates/cart/list", "templates/cart", cartDto);
    }

    @GetMapping("/up/{id}")
    public String qualityUp(@PathVariable long id,
                            @SessionAttribute(value = "cart", required = false) CartDto cartDto) {
        Product product = iProductService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/down/{id}")
    public String qualityDown(@PathVariable long id,
                              @SessionAttribute(value = "cart",required = false) CartDto cartDto) {
        Product product = iProductService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.downQuality(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id,
                                @SessionAttribute(value = "cart",required = false)CartDto cartDto) {
        Product product = iProductService.findById(id);
        if(product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cartDto.deleteProduct(productDto);
        }
        return "redirect:/cart";
    }
}