package com.example.phuc_spring.controller;

import com.example.phuc_spring.model.Blog;
import com.example.phuc_spring.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/bl")
public class BlogController {
    @Autowired
    private IBlogService service;

    @GetMapping("")
    public String showView(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "3", required = false) int size, Model model) {

        Sort sort = Sort.by("author").ascending();
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Blog> listBlog = service.findAll(pageable);
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
        service.update(blog, blog.getId());
        return "redirect:/bl";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        service.delete(id);
        return "redirect:/bl";
    }
}
