package com.example.ss6_blog.controller;

import com.example.ss6_blog.model.Blog;
import com.example.ss6_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bl")
public class BlogController {
    @Autowired
    private IBlogService service;

    @GetMapping("")
    public String showView(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "2", required = false) int size, Model model) {

        Sort sort = Sort.by("author").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Blog> listBlog = service.findAll(pageable);

        int sizePage = service.findAll(pageable).getTotalPages();
        List<Integer> listSoTrang = new ArrayList<>();
        for (int i = 1 ; i <= sizePage;i++){
            listSoTrang.add(i);
        }

        model.addAttribute("listSoTrang",listSoTrang);
        model.addAttribute("listBlog", listBlog);
        return "/list";
    }



    @GetMapping("/viewCreate")
    public String viewCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute Blog blog) {
        service.add(blog);
        return "redirect:/bl";
    }

    @GetMapping("/read/{id}")
    public String read(@PathVariable int id, Model model) {
        Blog blog = service.read(id);
        model.addAttribute("blog", blog);
        return "/read";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, Model model) {
        Blog blog = service.read(id);
        model.addAttribute("blog", blog);
        return "/update";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute Blog blog) {
        service.update(blog);
        return "redirect:/bl";
    }

    @PostMapping("/updatePost2")
    public String updatePost2(@ModelAttribute Blog blog) {
        service.update2(blog);
        return "redirect:/bl";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        service.delete(id);
        return "redirect:/bl";
    }
}
