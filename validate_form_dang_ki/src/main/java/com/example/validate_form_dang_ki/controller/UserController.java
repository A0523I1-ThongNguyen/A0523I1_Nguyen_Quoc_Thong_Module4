package com.example.validate_form_dang_ki.controller;

import com.example.validate_form_dang_ki.dto.UserDTO;
import com.example.validate_form_dang_ki.model.User;
import com.example.validate_form_dang_ki.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;

    @GetMapping("")
    public String showList(Model model){
        List<User> userList = service.findAll();
        model.addAttribute("userList",userList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("UserDTO",new UserDTO());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@Valid  @ModelAttribute("UserDTO") UserDTO userDTO, BindingResult bindingResult , RedirectAttributes redirectAttributes){
        new UserDTO().validate(userDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        service.add(user);
        return "redirect:/user";
    }

}
