package com.example.check_san_pham_orm.controller;

import com.example.check_san_pham_orm.model.SanPham;
import com.example.check_san_pham_orm.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sp")
public class SanPhamController {
    @Autowired
    private ISanPhamService sanPhamService;

    @GetMapping("")
    public String showView(Model model){
        List<SanPham> listSanPham = sanPhamService.findAll();
        model.addAttribute("listSanPham",listSanPham);
        return "/list";
    }

    @GetMapping("/viewCreate")
    public String showViewCreate(Model model){
        model.addAttribute("sanPham",new SanPham());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute SanPham sanPham){
        sanPhamService.save(sanPham);
        return "redirect:/sp";
    }

    @GetMapping("/getUptate")
    public String getUptate(@RequestParam int id,Model model){
       SanPham sanPham = sanPhamService.findById(id);
       model.addAttribute("sanPham",sanPham);
       return "/update";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute SanPham sanPham){
        sanPhamService.update(sanPham,sanPham.getId());
        return "redirect:/sp";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        sanPhamService.delete(id);
        return "redirect:/sp";
    }
}
