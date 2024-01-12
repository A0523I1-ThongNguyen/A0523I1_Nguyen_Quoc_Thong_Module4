package com.example.demo;


import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hi")
    public String sayHi(Model model) {
        model.addAttribute("massage","Testting");
        model.addAttribute("massage","Testting2");
        return "/hello";
    }
}
