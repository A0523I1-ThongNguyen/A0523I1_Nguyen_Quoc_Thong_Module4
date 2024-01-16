package com.example.demo4.controller;

import com.example.demo4.model.SanPham;
import com.example.demo4.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/sp")
public class SanPhamController {
    @Autowired
    private ISanPhamService service;

    @GetMapping("")
    public String showView(Model model) {
        List<SanPham> listSP = service.findAll();
        model.addAttribute("listSP", listSP);
        return "/list";
    }

    @GetMapping("/viewCreate")
    public String showViewCreate(Model model) {
        model.addAttribute("sanPham", new SanPham());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute SanPham sanPham) {
        service.add(sanPham);
        return "redirect:/sp";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        service.delete(id);
        return "redirect:/sp";
    }

    @GetMapping("/chitiet")
    public String chitiet(@RequestParam int id, Model model) {
        SanPham sanPham = service.findById(id);
        model.addAttribute("sanPham", sanPham);
        return "/chitiet";
    }

    @GetMapping("/viewUpdate")
    public String viewUpdate(@RequestParam int id, Model model) {
        SanPham sanPham = service.findById(id);
        model.addAttribute("sanPham", sanPham);
        return "/update";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute SanPham sanPham, RedirectAttributes redirectAttributes) {
        service.update(sanPham.getId(), sanPham);
        redirectAttributes.addFlashAttribute("ok", "Update Finish!");
        return "redirect:/sp";
    }

    @GetMapping("/search")
    public String updatePost(@RequestParam String searchPro, Model model, RedirectAttributes redirectAttributes) {
        List<SanPham> listSP = service.search(searchPro);
        if (listSP.size() > 0) {
            model.addAttribute("listSP", listSP);
            return "/list";
        } else {
            redirectAttributes.addFlashAttribute("noo", "Khong co san pham ten: " + searchPro);
            return "redirect:/sp";
        }


    }
}
