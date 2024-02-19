package com.example.ss7_check_blog.controller;

import com.example.ss7_check_blog.model.Blog;
import com.example.ss7_check_blog.model.Style;
import com.example.ss7_check_blog.service.blog.IBlogService;
import com.example.ss7_check_blog.service.style.IStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/check")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IStyleService styleService;

    @GetMapping("")
    public String showView(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Sort sort = Sort.by("idBlog").descending();
        Pageable pageable = PageRequest.of(page, 1, sort);
        Page<Blog> listPageBlog = blogService.listPageBlog(pageable);
        List<Style> listStyle =  styleService.getList();
        model.addAttribute("listPageBlog",listPageBlog);
        model.addAttribute("listStyle",listStyle);
        return "/list";
    }

    @GetMapping("/create")
    public String showViewCreate(Model model){
        model.addAttribute("blog",new Blog());
        List<Style> listStyle =  styleService.getList();
        model.addAttribute("listStyle",listStyle);
        return "/create";
    }
    @PostMapping("/createPost")
    public String createPost(@ModelAttribute Blog blog){
        blogService.add(blog);
        return "redirect:/check";
    }

}
