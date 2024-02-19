package com.example.demo_aop.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // use @ControllerAdvice
public class NotFoundClassException extends Exception{ // no need extends Exception
    @ExceptionHandler(NullPointerException.class)
    public ModelAndView ex(NullPointerException e){
        System.out.println("you have encountered an error : " + e.getMessage());
        ModelAndView modelAndView = new ModelAndView("/error_page");
        return modelAndView;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String ex2(IllegalArgumentException e){
        System.out.println("you have encountered an error : " + e.getMessage());
        return "/error2";
    }

    //    @ExceptionHandler(NotFoundClassException.class)
//    public String handleException() {
//        return "/error_page";
//    }
}
