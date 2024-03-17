package com.example.thi_module4.controller;

import com.example.thi_module4.dto.ProductDTO;
import com.example.thi_module4.model.Category;
import com.example.thi_module4.model.Product;
import com.example.thi_module4.service.ICategoryService;
import com.example.thi_module4.service.IProductService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("listCategory")
    public List<Category> showListCategory() {
        return iCategoryService.findAll();
    }

    @GetMapping("")
    public String showView(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Sort sort = Sort.by("price").ascending();
        Pageable pageable = PageRequest.of(page, 5);
        Page<Product> productPage = iProductService.findAll(pageable);
        model.addAttribute("productPage", productPage);
        return "/list";
    }

    @GetMapping("/createView")
    public String createView(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@Valid @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult bindingResult ,RedirectAttributes redirectAttributes) {
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Product productX = new Product();
        BeanUtils.copyProperties(productDTO,productX);
        iProductService.add(productX);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long idRequest , RedirectAttributes redirectAttributes){
        iProductService.delete(idRequest);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/product";
    }

    @GetMapping("/searchname")
    public String searchname(@RequestParam (defaultValue = "0", required = false) int page , @RequestParam String searchname , Model model){
        Pageable pageable = PageRequest.of(page,5);
        Page<Product> productPage = iProductService.searchByName(pageable,searchname);
        model.addAttribute("productPage",productPage);
        return "/list";
    }

    @GetMapping("/searchprice")
    public String searchPrice(@RequestParam (defaultValue = "0", required = false) int page , @RequestParam double searchPrice , Model model){
        Pageable pageable = PageRequest.of(page,5);
        Page<Product> productPage = iProductService.searchByPrice(pageable,searchPrice);
        model.addAttribute("productPage",productPage);
        return "/list";
    }

    @GetMapping("/searchCategory/{id}")
    public String searchCategory(@RequestParam (defaultValue = "0", required = false) int page ,@PathVariable Long id,Model model){
        Pageable pageable = PageRequest.of(page,5);
        Page<Product> productPage = iProductService.searchByCate(pageable,id);
        model.addAttribute("productPage",productPage);
        return "/list";
    }
    @GetMapping("/searchall")
    public String searchALL(@RequestParam  (defaultValue = "0", required = false) int page,
                            @RequestParam String searchnameall,
                            @RequestParam double searchpriceall , Model model){
        Pageable pageable = PageRequest.of(page,5);
        Page<Product> productPage = iProductService.searchAll(pageable,searchnameall,searchpriceall);

        model.addAttribute("productPage",productPage);

//        List<Product> productList = iProductService.findAll();
//
//        for(Product p : productList){
//            if (p.getNameProduct().equals(searchname) && p.getPrice() == searchprice){
//                Product productX = iProductService.findByID(p.getIdProduct());
//                model.addAttribute("productX",productX);
//                return "/list2";
//            }else {
//                return "redirect:/product";
//            }
//        }
        return "/list";
    }

}
