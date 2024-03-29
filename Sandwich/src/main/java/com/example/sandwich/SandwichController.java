package com.example.sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/sandwich")
public class SandwichController {
    @GetMapping(value = "/get")
    public String showView() {
        return "/list";
    }

    @PostMapping(value = "/post")
    public String handleSandwich(@RequestParam(name = "e", required = false, defaultValue = "No Choose") String[] e,
                                 @RequestParam(name = "z", required = false, defaultValue = "No Choose") String z, Model model) {
//        String listSand[] = e; // Or send e&z
        model.addAttribute("listSand", e);

//        String listIdol[] = z;
//        model.addAttribute("listIdol", z);

        return "/list";
    }


}
