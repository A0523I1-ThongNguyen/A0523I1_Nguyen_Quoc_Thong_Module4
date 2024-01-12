package com.codegym.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerEmployee {
    @Autowired
    private static Employee employee;
    @RequestMapping("employee")
    public String nameEm(){
        String tenNV = employee.getName();
        return tenNV;
    }

    public static void getName(){
        String tenNV = employee.getName();
        System.out.println(tenNV);
    }


}
