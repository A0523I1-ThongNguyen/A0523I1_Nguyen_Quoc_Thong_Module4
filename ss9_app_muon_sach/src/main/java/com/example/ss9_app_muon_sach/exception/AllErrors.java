package com.example.ss9_app_muon_sach.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
//public class AllErrors extends Exception {
//@ExceptionHandler(MethodArgumentNotValidException.class)
//public ModelAndView errorNull(MethodArgumentNotValidException methodArgumentNotValidException , ModelAndView modelAndView){
//    System.out.println("Lỗi 400" + methodArgumentNotValidException.getMessage());
//    modelAndView = new ModelAndView("error-null");
//    return modelAndView;
//}
//}
