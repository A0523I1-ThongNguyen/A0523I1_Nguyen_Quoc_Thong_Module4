package com.example.ss7_next_level_blog.controller;

import com.example.ss7_next_level_blog.model.Blog;
import com.example.ss7_next_level_blog.model.Category;
import com.example.ss7_next_level_blog.service.blog.IBlogService;
import com.example.ss7_next_level_blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nextbl")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showView(@RequestParam(defaultValue = "0", required = false) int page,
                           Model model) {
        Sort sort = Sort.by("author").ascending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<Blog> listBlog = iBlogService.findAll(pageable);
        List<Category> categoryList = iCategoryService.showList();

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("listBlog", listBlog);

        return "/list";
    }

    @GetMapping("getSearch")
    public String showSearch(@RequestParam String search,
                             @PageableDefault(page = 0, size = 1, sort = "content", direction = Sort.Direction.ASC) Pageable pageable2, Model model) {
        List<Category> categoryList = iCategoryService.showList();
        Page<Blog> listSearch = iBlogService.findByTitleContaining(pageable2, search);
        Page<Blog> listSlistSearchContentearch = iBlogService.findByContentContaining(pageable2, search);
        model.addAttribute("listSlistSearchContentearch", listSlistSearchContentearch);
        model.addAttribute("listSearch", listSearch);
        model.addAttribute("categoryList", categoryList);
        return "/search";
    }

    @GetMapping("viewCreate")
    public String showViewCreate(Model model) {
        model.addAttribute("blog", new Blog());
        List<Category> listCategory = iCategoryService.showList();
        model.addAttribute("listCategory", listCategory);
        return "/create";
    }

    @PostMapping("createPost")
    public String createPost(@ModelAttribute Blog blog) {
        iBlogService.add(blog);
        return "redirect:/nextbl";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable int id, Model model) {
        Blog blog = iBlogService.read(id);
        model.addAttribute("blog", blog);
        return "/update";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute Blog blog) {
        iBlogService.update(blog);
        return "redirect:/nextbl";
    }

    @GetMapping("/read")
    public String read(@RequestParam int id, Model model) {
        Blog blog = iBlogService.read(id);
        model.addAttribute("blog", blog);
        return "/read";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        iBlogService.delete(id);
        return "redirect:/nextbl";
    }

    @GetMapping("/category/{categoryID}")
    public String showCategory(@PageableDefault(page = 0, size = 2) Pageable pageable, @PathVariable int categoryID, Model model) {
        Page<Blog> blogOfCategory = iBlogService.showListCategoryId(pageable, categoryID);
        List<Category> categoryList = iCategoryService.showList();
        model.addAttribute("blogOfCategory", blogOfCategory);
        model.addAttribute("categoryList", categoryList);
//        model.addAttribute("categoryID", categoryID);
        return "/category";
    }

    @GetMapping("/category2/{categoryID}")
    public String showCategory2(@PageableDefault(page = 0, size = 2) Pageable pageable, @PathVariable int categoryID, Model model) {
        List<Blog> blogOfCategory = iBlogService.listBlogQuery(pageable, categoryID);
        List<Category> categoryList = iCategoryService.showList();
        model.addAttribute("blogOfCategory", blogOfCategory);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("categoryID", categoryID);
        return "/category";
    }
}
