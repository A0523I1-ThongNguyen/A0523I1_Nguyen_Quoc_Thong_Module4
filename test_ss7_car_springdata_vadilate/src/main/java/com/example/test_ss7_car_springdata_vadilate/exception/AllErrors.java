package com.example.test_ss7_car_springdata_vadilate.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AllErrors extends Exception {
    @ExceptionHandler(NullPointerException.class)
    public ModelAndView errorNull(NullPointerException nullPointerException , ModelAndView modelAndView){
        System.out.println("Lỗi Ngoại lệ con trỏ Null" + nullPointerException.getMessage());
        modelAndView = new ModelAndView("error-null");
        return modelAndView;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String errorArgument(IllegalArgumentException illegalArgumentException){
        System.out.println("Lỗi Ngoại lệ Đối số bất hợp pháp IllegalArgumentException: " + illegalArgumentException.getMessage());
        return "error-argument";
    }
}
